package com.teguhmuflih.restfulkotlin.config

import com.teguhmuflih.restfulkotlin.entity.ApiKey
import com.teguhmuflih.restfulkotlin.repository.ApiKeyRepository
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner

class ApiKeySeeder(val apiKeyRepository: ApiKeyRepository) : ApplicationRunner {
    val apiKey = "SECRET"

    override fun run(args: ApplicationArguments?) {
        if (!apiKeyRepository.existsById(apiKey)) {
            val entity = ApiKey(id = apiKey)
            apiKeyRepository.save(entity)
        }
    }


}