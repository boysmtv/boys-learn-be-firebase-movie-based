package boys.mtv.kotlin.movie.model

import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class ProductRequest (

    @field:NotBlank
    val id: String?,

    @field:NotBlank
    val name: String?,

    @field:NotNull
    @field:Min(value = 0)
    val price: Long?,

    @field:NotNull
    @field:Min(value = 0)
    val quantity: Int?

)