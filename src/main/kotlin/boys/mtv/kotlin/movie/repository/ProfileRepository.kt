package boys.mtv.kotlin.movie.repository

import boys.mtv.kotlin.movie.entity.LoginEntity
import boys.mtv.kotlin.movie.entity.ProfileEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface ProfileRepository : JpaRepository<ProfileEntity, String> {

    @Query("SELECT * FROM profile WHERE email = :email ORDER by email DESC LIMIT 1", nativeQuery = true)
    fun findUserByEmail(email: String): ProfileEntity?

}