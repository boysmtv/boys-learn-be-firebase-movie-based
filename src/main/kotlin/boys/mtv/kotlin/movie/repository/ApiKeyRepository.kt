package boys.mtv.kotlin.movie.repository

import boys.mtv.kotlin.movie.entity.ApiKey
import org.springframework.data.jpa.repository.JpaRepository

interface ApiKeyRepository : JpaRepository<ApiKey, String>