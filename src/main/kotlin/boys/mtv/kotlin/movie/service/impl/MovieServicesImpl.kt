package boys.mtv.kotlin.movie.service.impl

import boys.mtv.kotlin.movie.common.util.TransactionUtil
import boys.mtv.kotlin.movie.entity.LoginEntity
import boys.mtv.kotlin.movie.entity.ProfileEntity
import boys.mtv.kotlin.movie.error.NotFoundException
import boys.mtv.kotlin.movie.model.movie.*
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

        val entity = ProfileEntity(
                id = TransactionUtil.generateTransactionID(),
                firstName = model.firstName,
                lastName = model.lastName,
                phoneNumber = model.phoneNumber,
                email = model.email,
                password = model.password,
                createdAt = Date(),
                updatedAt = null
        )

        profileRepository.save(entity)

        return RegisterResponse(
                id = entity.id,
                fullName = "${entity.firstName} ${entity.lastName}",
                createdAt = entity.createdAt,
                updatedAt = entity.updatedAt
        )
    }

    override fun login(model: LoginRequest): LoginResponse {
        validationUtil.validate(model)

        val profile = profileRepository.findUserByEmail(model.email)
        if (profile != null) {
            if (profile.password == model.password) {
                val entity = LoginEntity(
                        id = TransactionUtil.generateTransactionID(),
                        idProfile = profile.id,
                        email = model.email,
                        createdAt = Date(),
                )
                loginRepository.save(entity)

                return LoginResponse(
                        id = entity.id,
                        fullName = "${profile.firstName} ${profile.lastName}",
                        createdAt = profile.createdAt,
                )
            } else throw NotFoundException()
        } else {
            throw NotFoundException()
        }
    }

    override fun getProfile(model: ProfileRequest): ProfileResponse {
        validationUtil.validate(model)

        return buildResponseProfile(
                model = findProductByIdOrThrowNotFound(
                        id = model.id
                )
        )
    }

    private fun buildResponseProfile(model: ProfileEntity): ProfileResponse {
        return ProfileResponse(
                id = model.id,
                firstName = model.firstName,
                lastName = model.lastName,
                phoneNumber = model.phoneNumber,
                email = model.email,
                createdAt = model.createdAt,
                updatedAt = model.updatedAt
        )
    }

    private fun findProductByIdOrThrowNotFound(id: String): ProfileEntity {
        val entity = profileRepository.findByIdOrNull(id)
        if (entity != null) return entity
        else throw NotFoundException()
    }

}