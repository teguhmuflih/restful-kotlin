package com.teguhmuflih.restfulkotlin.controller

import com.teguhmuflih.restfulkotlin.model.*
import com.teguhmuflih.restfulkotlin.service.ProductService
import org.springframework.web.bind.annotation.*

@RestController
class ProductController(val productService: ProductService) {

    @PostMapping(
        value = ["/api/products"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun createProduct(@RequestBody body: CreateProductRequest): WebResponse<ProductResponse> {
        val response = productService.create(body)

        return WebResponse(
            code = "200",
            status = "Success",
            data = response
        )
    }

    @GetMapping(
        value = ["/api/products/{idProduct}"],
        produces = ["application/json"]
    )
    fun getProduct(@PathVariable("idProduct") id: String): WebResponse<ProductResponse> {
        val response = productService.get(id)
        return WebResponse(
            code = "200",
            status = "Success",
            data = response
        )
    }

    @PutMapping(
        value = ["/api/products/{idProduct}"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun updateProduct(
        @PathVariable("idProduct") id: String,
        @RequestBody updateProductRequest: UpdateProductRequest
    ): WebResponse<ProductResponse> {
        val response = productService.update(id, updateProductRequest)
        return WebResponse(
            code = "200",
            status = "Success",
            data = response
        )
    }

    @DeleteMapping(
        value = ["/api/products/{idProduct}"],
        produces = ["application/json"]
    )
    fun deleteProduct(@PathVariable("idProduct") id: String): WebResponse<String> {
        productService.delete(id)
        return WebResponse(
            code = "200",
            status = "Success",
            data = id
        )
    }

    @GetMapping(
        value = ["/api/products"],
        produces = ["application/json"]
    )
    fun listProduct(
        @RequestParam(value = "size", defaultValue = "10") size: Int,
        @RequestParam(value = "page", defaultValue = "0") page: Int
    ): WebResponse<List<ProductResponse>> {
        val request = ListProductRequest(page = page, size = size)
        val response = productService.list(request)
        return WebResponse(
            code = "200",
            status = "Success",
            data = response
        )
    }
}