package boys.mtv.kotlin.movie.repository

import boys.mtv.kotlin.movie.entity.ApiKeyEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ApiKeyRepository : JpaRepository<ApiKeyEntity, String>