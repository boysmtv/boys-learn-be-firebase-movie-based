package boys.mtv.kotlin.movie.config

import boys.mtv.kotlin.movie.entity.ApiKeyEntity
import boys.mtv.kotlin.movie.repository.ApiKeyRepository
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class ApiKeySeeder(val apiKeyRepository: ApiKeyRepository) : ApplicationRunner {

    val apiKey = "SECRET"

    override fun run(args: ApplicationArguments?) {
        if (!apiKeyRepository.existsById(apiKey)){
            val entity = ApiKeyEntity(id = apiKey)
            apiKeyRepository.save(entity)
        }
    }

}