package boys.mtv.kotlin.movie.repository

import boys.mtv.kotlin.movie.entity.LoginEntity
import org.springframework.data.jpa.repository.JpaRepository

interface LoginRepository : JpaRepository<LoginEntity, String>