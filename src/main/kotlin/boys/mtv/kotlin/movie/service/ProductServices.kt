package boys.mtv.kotlin.movie.service

import boys.mtv.kotlin.movie.model.ListProductRequest
import boys.mtv.kotlin.movie.model.ProductRequest
import boys.mtv.kotlin.movie.model.ProductResponse
import boys.mtv.kotlin.movie.model.UpdateProductRequest

interface ProductServices {

    fun create(productRequest: ProductRequest) : ProductResponse

    fun get(id: String) : ProductResponse

    fun update(id: String, updateProductRequest: UpdateProductRequest) : ProductResponse

    fun detele(id: String)

    fun list(listProductRequest: ListProductRequest) : List<ProductResponse>

}