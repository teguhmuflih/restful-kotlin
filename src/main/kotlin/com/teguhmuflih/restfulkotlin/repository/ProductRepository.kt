package com.teguhmuflih.restfulkotlin.repository

import com.teguhmuflih.restfulkotlin.entity.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository: JpaRepository<Product, String> {
}