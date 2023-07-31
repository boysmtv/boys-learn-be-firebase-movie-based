package boys.mtv.kotlin.movie.model.movie

import java.util.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class RegisterRequest(

        @field:NotBlank
        @field:NotNull
        val firstName: String,

        @field:NotBlank
        @field:NotNull
        val lastName: String,

        @field:NotBlank
        @field:NotNull
        val phoneNumber: String,

        @field:NotBlank
        @field:NotNull
        val email: String,

        @field:NotBlank
        @field:NotNull
        val password: String

)

data class RegisterResponse(
        val id: String,
        val fullName: String,
        val createdAt: Date,
        val updatedAt: Date?
)