package multiversebootcamp.springboot.utils

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

// This annotation will let spring know how to handle exceptions when they occur within the Rest
// controller class
@RestControllerAdvice
class ExceptionHandler {
    @ExceptionHandler(Exception::class)
    fun exceptionHandler(e: Exception): ResponseEntity<ApiError> {
        val error = ApiError(e.message)
        return ResponseEntity(error, error.status)
    }
}
