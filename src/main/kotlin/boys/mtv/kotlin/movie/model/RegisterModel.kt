package boys.mtv.kotlin.movie.model

import java.util.*
import javax.validation.constraints.Email
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class RegisterRequest(

        @NotNull(message = "The firstName is required.")
        @NotBlank(message = "The firstName is required.")
        val firstName: String,

        @NotNull(message = "The lastName is required.")
        @NotBlank(message = "The lastName is required.")
        val lastName: String,

        @NotNull(message = "The displayName is required.")
        @NotBlank(message = "The displayName is required.")
        val displayName: String,

        @NotNull(message = "The phoneNumber is required.")
        @NotBlank(message = "The phoneNumber is required.")
        val phone: String,

        @Email
        @NotNull(message = "The email is required.")
        @NotBlank(message = "The email is required.")
        val email: String,

        @NotNull(message = "The password is required.")
        @NotBlank(message = "The password is required.")
        @Min(value = 8, message = "The number of password must be greater than 8 digits")
        @Max(value = 32, message = "The number of password must be greater than 32 digits")
        val password: String,

        @NotNull(message = "The method is required.")
        @NotBlank(message = "The method is required.")
        val method: String,

        )

data class RegisterResponse(
        val id: String?,
        val fullName: String?,
        val createdAt: Date?,
        val updatedAt: Date?
)