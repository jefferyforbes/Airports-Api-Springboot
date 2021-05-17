package multiversebootcamp.springboot.utils

import org.springframework.http.HttpStatus

data class ApiError(
    private val exceptionMessage: String?,
    val status: HttpStatus = HttpStatus.BAD_REQUEST,
    val code: Int = status.value()
) {
    val message: String
    // This getter checks the api exception if there is an error message and returns it, else -> it returns a generic
    // message; "Error occurred"
    get() = exceptionMessage ?: "Error occurred"
}
