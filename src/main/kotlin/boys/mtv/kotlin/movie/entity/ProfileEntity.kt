package boys.mtv.kotlin.movie.entity

import net.bytebuddy.implementation.bind.annotation.Default
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

        @Column(name = "idFireStore")
        val idFireStore: String? = null,

        @Column(name = "idGoogle")
        val idGoogle: String? = null,

        @Column(name = "idToken")
        val idToken: String? = null,

        @Column(name = "firstName")
        var firstName: String? = null,

        @Column(name = "lastName")
        var lastName: String? = null,

        @Column(name = "displayName")
        var displayName: String? = null,

        @Column(name = "phoneNumber")
        var phone: String? = null,

        @Column(name = "email")
        var email: String? = null,

        @Column(name = "password")
        var password: String? = null,

        @Column(name = "photoUrl")
        var photoUrl: String? = null,

        @Column(name = "method")
        var method: String? = null,

        @Column(name = "createdAt")
        var createdAt: Date? = null,

        @Column(name = "updatedAt")
        var updatedAt: Date? = null

)