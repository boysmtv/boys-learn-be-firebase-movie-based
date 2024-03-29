package boys.mtv.kotlin.movie.service.impl

import boys.mtv.kotlin.movie.common.util.TransactionUtil
import boys.mtv.kotlin.movie.entity.LoginEntity
import boys.mtv.kotlin.movie.entity.ProfileEntity
import boys.mtv.kotlin.movie.error.ConflictException
import boys.mtv.kotlin.movie.error.NotFoundException
import boys.mtv.kotlin.movie.error.UnauthorizedException
import boys.mtv.kotlin.movie.model.*
import boys.mtv.kotlin.movie.repository.LoginRepository
import boys.mtv.kotlin.movie.repository.ProfileRepository
import boys.mtv.kotlin.movie.service.MovieServices
import boys.mtv.kotlin.movie.validation.ValidationUtil
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*

@Service
class MovieServicesImpl(
        val profileRepository: ProfileRepository,
        val loginRepository: LoginRepository,
        val validationUtil: ValidationUtil
) : MovieServices {

    override fun register(model: RegisterRequest): RegisterResponse {

        validationUtil.validate(model)

        val profile = profileRepository.findUserByEmail(model.email)
        if (profile == null) {
            val regDate = Date()
            val entity = ProfileEntity(
                    id = TransactionUtil.generateTransactionID(),
                    firstName = model.firstName,
                    lastName = model.lastName,
                    displayName = model.displayName,
                    phone = model.phone,
                    email = model.email,
                    password = model.password,
                    method = model.method,
                    createdAt = regDate,
                    updatedAt = regDate
            )

            profileRepository.save(entity)

            return RegisterResponse(
                    id = entity.id,
                    fullName = entity.displayName,
                    createdAt = entity.createdAt,
                    updatedAt = entity.updatedAt
            )
        } else throw ConflictException()

    }

    override fun login(model: LoginRequest): LoginResponse {
        validationUtil.validate(model)

        val profile = profileRepository.findUserByEmail(model.email)
        if (profile != null) {
            if (profile.password == model.password) {
                val entity = LoginEntity(
                        id = TransactionUtil.generateTransactionID(),
                        idProfile = profile.id,
                        email = profile.email,
                        createdAt = Date(),
                )
                loginRepository.save(entity)

                return LoginResponse(
                        id = profile.id,
                        fullName = "${profile.firstName} ${profile.lastName}",
                        createdAt = profile.createdAt,
                )
            } else throw UnauthorizedException()
        } else {
            throw NotFoundException()
        }
    }

    override fun getProfile(model: ProfileRequest): ProfileResponse {
        validationUtil.validate(model)

        return buildResponseProfile(
                model = findProfileByIdOrThrowNotFound(
                        id = model.id
                )
        )
    }

    private fun buildResponseProfile(model: ProfileEntity): ProfileResponse {
        return ProfileResponse(
                id = model.id,
                firstName = model.firstName,
                lastName = model.lastName,
                phoneNumber = model.phone,
                email = model.email,
                createdAt = model.createdAt,
                updatedAt = model.updatedAt
        )
    }

    private fun findProfileByIdOrThrowNotFound(id: String): ProfileEntity {
        val entity = profileRepository.findByIdOrNull(id)
        if (entity != null) return entity
        else throw NotFoundException()
    }

}