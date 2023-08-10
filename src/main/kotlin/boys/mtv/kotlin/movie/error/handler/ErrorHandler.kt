package boys.mtv.kotlin.movie.error.handler

import boys.mtv.kotlin.movie.error.ConflictException
import boys.mtv.kotlin.movie.error.NotFoundException
import boys.mtv.kotlin.movie.error.UnauthorizedException
import boys.mtv.kotlin.movie.model.WebResponse
import com.fasterxml.jackson.core.JsonParseException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.validation.ConstraintViolationException

@RestControllerAdvice
class ErrorHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = [ConstraintViolationException::class])
    fun validationHandler(constraintViolationException: ConstraintViolationException): WebResponse<String> {
        return WebResponse(
                code = 400,
                status = "BAD REQUEST",
                data = constraintViolationException.message!!
        )
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = [NotFoundException::class])
    fun notFound(notFoundException: NotFoundException): WebResponse<String> {
        return WebResponse(
                code = 404,
                status = "NOT FOUND",
                data = "No Available Data"
        )
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(value = [UnauthorizedException::class])
    fun unauthorized(unauthorizedException: UnauthorizedException): WebResponse<String> {
        return WebResponse(
                code = 401,
                status = "UNAUTHORIZED",
                data = "Invalid Credentials"
        )
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(value = [ConflictException::class])
    fun conflict(notFoundException: ConflictException): WebResponse<String> {
        return WebResponse(
                code = 409,
                status = "Conflict",
                data = "Data already exists"
        )
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(JsonParseException::class)
    fun jsonParseException(ex: JsonParseException): WebResponse<String> {
        return WebResponse(
                code = 400,
                status = "BAD REQUEST",
                data = "Please check your request"
        )
    }

}