package com.teguhmuflih.restfulkotlin.service.impl

import com.teguhmuflih.restfulkotlin.entity.Product
import com.teguhmuflih.restfulkotlin.error.NotFoundException
import com.teguhmuflih.restfulkotlin.model.CreateProductRequest
import com.teguhmuflih.restfulkotlin.model.ListProductRequest
import com.teguhmuflih.restfulkotlin.model.ProductResponse
import com.teguhmuflih.restfulkotlin.model.UpdateProductRequest
import com.teguhmuflih.restfulkotlin.repository.ProductRepository
import com.teguhmuflih.restfulkotlin.service.ProductService
import com.teguhmuflih.restfulkotlin.validation.ValidationUtil
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collector
import java.util.stream.Collectors

@Service
class ProductServiceImpl(
    val productRepository: ProductRepository,
    val validationUtil: ValidationUtil
) : ProductService {
    override fun create(createProductRequest: CreateProductRequest): ProductResponse {
        validationUtil.validate(createProductRequest)

        val product = Product(
            id = createProductRequest.id!!,
            name = createProductRequest.name!!,
            price = createProductRequest.price!!,
            quantity = createProductRequest.quantity!!,
            createdAt = Date(),
            updatedAt = null
        )

        productRepository.save(product)

        return convertProductToProductResponse(product)
    }

    override fun delete(id: String) {
        val product = productRepository.findByIdOrNull(id) ?: throw NotFoundException()
        productRepository.delete(product)
    }

    override fun list(listProductRequest: ListProductRequest): List<ProductResponse> {
        val page = productRepository.findAll(PageRequest.of(listProductRequest.page, listProductRequest.size))
        val products : List<Product> = page.get().collect(Collectors.toList())
        return products.map { convertProductToProductResponse(it) }
    }

    override fun get(id: String): ProductResponse {
        val product = productRepository.findByIdOrNull(id)
        return if (product == null) {
            throw NotFoundException()
        } else {
            convertProductToProductResponse(product)
        }
    }

    override fun update(id: String, updateProductRequest: UpdateProductRequest): ProductResponse {
        val product = productRepository.findByIdOrNull(id) ?: throw NotFoundException()

        validationUtil.validate(updateProductRequest)

        product.apply {
            name = updateProductRequest.name!!
            price = updateProductRequest.price!!
            quantity = updateProductRequest.quantity!!
            updatedAt = Date()
        }

        productRepository.save(product)

        return convertProductToProductResponse(product)
    }

    private fun convertProductToProductResponse(product: Product): ProductResponse {
        return ProductResponse(
            id = product.id,
            name = product.name,
            price = product.price,
            quantity = product.quantity,
            createdAt = product.createdAt,
            updatedAt = product.updatedAt
        )
    }
}