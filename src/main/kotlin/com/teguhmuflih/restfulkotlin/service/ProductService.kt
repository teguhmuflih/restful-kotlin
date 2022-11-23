package com.teguhmuflih.restfulkotlin.service

import com.teguhmuflih.restfulkotlin.model.CreateProductRequest
import com.teguhmuflih.restfulkotlin.model.ListProductRequest
import com.teguhmuflih.restfulkotlin.model.ProductResponse
import com.teguhmuflih.restfulkotlin.model.UpdateProductRequest


interface ProductService {
    fun create(createProductRequest: CreateProductRequest): ProductResponse

    fun get(id: String): ProductResponse

    fun update(id: String, updateProductRequest: UpdateProductRequest): ProductResponse

    fun delete(id: String)

    fun list(listProductRequest: ListProductRequest): List<ProductResponse>
}