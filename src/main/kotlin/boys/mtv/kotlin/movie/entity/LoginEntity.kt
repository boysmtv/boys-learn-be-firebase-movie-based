package boys.mtv.kotlin.movie.entity

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "login")
data class LoginEntity(

        @Id
        val id: String,

        @Column(name = "email")
        var email: String,

        @Column(name = "password")
        var password: String,

        @Column(name = "createdAt")
        var createdAt: Date,

)