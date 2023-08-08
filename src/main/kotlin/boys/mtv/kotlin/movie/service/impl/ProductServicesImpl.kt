package boys.mtv.kotlin.movie.service.impl

import boys.mtv.kotlin.movie.entity.ProductEntity
import boys.mtv.kotlin.movie.error.NotFoundException
import boys.mtv.kotlin.movie.model.ListProductRequest
import boys.mtv.kotlin.movie.model.ProductRequest
import boys.mtv.kotlin.movie.model.ProductResponse
import boys.mtv.kotlin.movie.model.UpdateProductRequest
import boys.mtv.kotlin.movie.repository.ProductRepository
import boys.mtv.kotlin.movie.service.ProductServices
import boys.mtv.kotlin.movie.validation.ValidationUtil
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class ProductServicesImpl(
        val productRepository: ProductRepository,
        val validationUtil: ValidationUtil
    ) : ProductServices {

    override fun create(productRequest: ProductRequest): ProductResponse {

        validationUtil.validate(productRequest)

        val productEntity = ProductEntity(
                id = productRequest.id!!,
                name = productRequest.name!!,
                price = productRequest.price!!,
                quantity = productRequest.quantity!!,
                created_at = Date(),
                updated_at = null
        )

        productRepository.save(productEntity)

        return convertResponse(productEntity)
    }

    override fun get(id: String): ProductResponse {
        return convertResponse(findProductByIdOrThrowNotFound(id))
    }

    override fun update(id: String, updateProductRequest: UpdateProductRequest): ProductResponse {
        validationUtil.validate(updateProductRequest)

        val product = findProductByIdOrThrowNotFound(id)
        product.apply {
            name = updateProductRequest.name!!
            price = updateProductRequest.price!!
            quantity = updateProductRequest.quantity!!
            updated_at = Date()
        }
        productRepository.save(product)
        return convertResponse(product)
    }

    override fun detele(id: String) {
        productRepository.delete(findProductByIdOrThrowNotFound(id))
    }

    override fun list(listProductRequest: ListProductRequest): List<ProductResponse> {
        val page = productRepository.findAll(PageRequest.of(listProductRequest.page, listProductRequest.size))
        val productEntity: List<ProductEntity> = page.get().collect(Collectors.toList())
        return productEntity.map { convertResponse(it) }
    }

    private fun findProductByIdOrThrowNotFound(id: String) : ProductEntity {
        val product = productRepository.findByIdOrNull(id)
        if (product == null) {
            throw NotFoundException()
        }else{
            return product
        }
    }

    private fun convertResponse(productEntity: ProductEntity) : ProductResponse {
        return ProductResponse(
                id = productEntity.id,
                name = productEntity.name,
                price = productEntity.price,
                quantity = productEntity.quantity,
                created_at = productEntity.created_at,
                updated_at = productEntity.updated_at
        )
    }

}