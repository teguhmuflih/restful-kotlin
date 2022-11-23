package com.teguhmuflih.restfulkotlin.controller

import com.teguhmuflih.restfulkotlin.error.NotFoundException
import com.teguhmuflih.restfulkotlin.error.UnauthorizedException
import com.teguhmuflih.restfulkotlin.model.WebResponse
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.validation.ConstraintViolationException

@RestControllerAdvice
class ErrorController {

    @ExceptionHandler(value = [ConstraintViolationException::class])
    fun validationHandler(constraintViolationException: ConstraintViolationException): WebResponse<String>{
        return WebResponse(
            code = "402",
            status = "BAD REQUEST",
            data = constraintViolationException.message!!
        )
    }

    @ExceptionHandler(value = [NotFoundException::class])
    fun notFound(notFoundException: NotFoundException): WebResponse<String>{
        return WebResponse(
            code = "404",
            status = "NOT FOUND",
            data = "Not Found"
        )
    }

    @ExceptionHandler(value = [UnauthorizedException::class])
    fun unauthorized(unauthorizedException: UnauthorizedException): WebResponse<String>{
        return WebResponse(
            code = "401",
            status = "UNAUTHORIZED",
            data = "please put your X-Api-Key"
        )
    }
}