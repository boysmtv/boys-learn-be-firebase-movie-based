package boys.mtv.kotlin.movie.repository

import boys.mtv.kotlin.movie.entity.ProductEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<ProductEntity, String>