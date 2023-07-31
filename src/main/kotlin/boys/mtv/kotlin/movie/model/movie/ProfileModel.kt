package boys.mtv.kotlin.movie.model.movie

import java.util.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class ProfileRequest(

        @field:NotBlank
        @field:NotNull
        val id: String,

        @field:NotBlank
        @field:NotNull
        val email: String,

)

data class ProfileResponse(
        val id: String,
        val firstName: String,
        val lastName: String,
        val phoneNumber: String,
        val email: String,
        val createdAt: Date,
        val updatedAt: Date?
)