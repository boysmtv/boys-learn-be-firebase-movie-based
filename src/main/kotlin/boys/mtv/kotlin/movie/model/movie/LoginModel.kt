package boys.mtv.kotlin.movie.model.movie

import java.util.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class LoginRequest(

        @field:NotBlank
        @field:NotNull
        val email: String,

        @field:NotBlank
        @field:NotNull
        val password: String

)

data class LoginResponse(
        val id: String,
        val fullName: String,
        val createdAt: Date
)