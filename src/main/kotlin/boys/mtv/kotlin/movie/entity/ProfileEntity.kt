package boys.mtv.kotlin.movie.entity

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "profile")
data class ProfileEntity(

        @Id
        val id: String,

        @Column(name = "firstName")
        var firstName: String,

        @Column(name = "lastName")
        var lastName: String,

        @Column(name = "phoneNumber")
        var phoneNumber: String,

        @Column(name = "email")
        var email: String,

        @Column(name = "password")
        var password: String,

        @Column(name = "createdAt")
        var createdAt: Date,

        @Column(name = "updatedAt")
        var updatedAt: Date?

)