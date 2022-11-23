package com.teguhmuflih.restfulkotlin.model

import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class UpdateProductRequest(
    @field:NotBlank
    val name : String?,

    @field:NotBlank
    val price : Long?,

    @field:NotNull
    @Min(value = 0)
    val quantity : Int?
)
