package boys.mtv.kotlin.movie.model

import java.util.*

data class ProductResponse (
    val id: String,
    val name: String,
    val price: Long,
    val quantity: Int,
    val created_at: Date,
    val updated_at: Date?
)