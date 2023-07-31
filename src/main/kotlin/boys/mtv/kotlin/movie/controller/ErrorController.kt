package boys.mtv.kotlin.movie.controller

import boys.mtv.kotlin.movie.error.NotFoundException
import boys.mtv.kotlin.movie.error.UnauthorizedException
import boys.mtv.kotlin.movie.model.WebResponse
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.validation.ConstraintViolationException

@RestControllerAdvice
class ErrorController {

    @ExceptionHandler(value = [ConstraintViolationException::class])
    fun validationHandler(constraintViolationException: ConstraintViolationException) : WebResponse<String> {
        return WebResponse(
                code = 400,
                status = "BAD REQUEST",
                data = constraintViolationException.message!!
        )
    }

    @ExceptionHandler(value = [NotFoundException::class])
    fun notFound(notFoundException: NotFoundException) : WebResponse<String> {
        return WebResponse(
                code = 404,
                status = "NOT FOUND",
                data = "No Availbale Data"
        )
    }


    @ExceptionHandler(value = [UnauthorizedException::class])
    fun unauthorized(unauthorizedException: UnauthorizedException) : WebResponse<String> {
        return WebResponse(
                code = 401,
                status = "UNAUTHORIZED",
                data = "Please put your X-API-Key"
        )
    }

}