package boys.mtv.kotlin.movie.repository

import boys.mtv.kotlin.movie.entity.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, String>