package com.teguhmuflih.restfulkotlin.repository

import com.teguhmuflih.restfulkotlin.entity.ApiKey
import org.springframework.data.jpa.repository.JpaRepository

interface ApiKeyRepository : JpaRepository<ApiKey,String> {
}