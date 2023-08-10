package boys.mtv.kotlin.movie.error.handler

import boys.mtv.kotlin.movie.model.WebResponse
import org.hibernate.TypeMismatchException
import org.springframework.beans.ConversionNotSupportedException
import org.springframework.http.HttpStatus
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.http.converter.HttpMessageNotWritableException
import org.springframework.validation.FieldError
import org.springframework.validation.ObjectError
import org.springframework.web.HttpMediaTypeNotAcceptableException
import org.springframework.web.HttpMediaTypeNotSupportedException
import org.springframework.web.HttpRequestMethodNotSupportedException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.MissingPathVariableException
import org.springframework.web.bind.MissingServletRequestParameterException
import org.springframework.web.bind.ServletRequestBindingException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.context.request.async.AsyncRequestTimeoutException
import org.springframework.web.multipart.support.MissingServletRequestPartException
import org.springframework.web.servlet.NoHandlerFoundException
import java.net.BindException
import java.util.function.Consumer

@RestControllerAdvice
class ExceptionHandler {

    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException::class)
    fun methodNotSupported(ex: HttpRequestMethodNotSupportedException): WebResponse<String> {
        return WebResponse(
                code = 405,
                status = "METHOD NOT ALLOWED",
                data = "Please check your request"
        )
    }

    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler(HttpMediaTypeNotSupportedException::class)
    fun mediaTypeNotSupported(ex: HttpMediaTypeNotSupportedException): WebResponse<String> {
        return WebResponse(
                code = 415,
                status = "UNSUPPORTED MEDIA TYPE",
                data = "Please check your request"
        )
    }

    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ExceptionHandler(HttpMediaTypeNotAcceptableException::class)
    fun notAcceptable(ex: HttpMediaTypeNotAcceptableException): WebResponse<String> {
        return WebResponse(
                code = 406,
                status = "NOT ACCEPTABLE",
                data = "Please check your request"
        )
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(MissingPathVariableException::class)
    fun missingPathVariable(ex: MissingPathVariableException): WebResponse<String> {
        return WebResponse(
                code = 500,
                status = "INTERNAL SERVER ERROR",
                data = "Please check your request"
        )
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestParameterException::class)
    fun missingParam(ex: MissingServletRequestParameterException): WebResponse<String> {
        return WebResponse(
                code = 400,
                status = "BAD REQUEST",
                data = ex.message
        )
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestPartException::class)
    fun missingServletRequest(ex: MissingServletRequestPartException): WebResponse<String> {
        return WebResponse(
                code = 400,
                status = "BAD REQUEST",
                data = "Please check your request"
        )
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ServletRequestBindingException::class)
    fun servletRequestBinding(ex: ServletRequestBindingException): WebResponse<String> {
        return WebResponse(
                code = 400,
                status = "BAD REQUEST",
                data = "Please check your request"
        )
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ConversionNotSupportedException::class)
    fun conversionNotSupported(ex: ConversionNotSupportedException): WebResponse<String> {
        return WebResponse(
                code = 500,
                status = "INTERNAL SERVER ERROR",
                data = "Please check your request"
        )
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(TypeMismatchException::class)
    fun typeMismatch(ex: TypeMismatchException): WebResponse<String> {
        return WebResponse(
                code = 400,
                status = "BAD REQUEST",
                data = "Please check your request"
        )
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException::class)
    fun httpMessageNotReadable(ex: HttpMessageNotReadableException): WebResponse<String> {
        return WebResponse(
                code = 400,
                status = "BAD REQUEST",
                data = "Please check your request"
        )
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(HttpMessageNotWritableException::class)
    fun httpMessageNotWritable(ex: HttpMessageNotWritableException): WebResponse<String> {
        return WebResponse(
                code = 500,
                status = "INTERNAL SERVER ERROR",
                data = "Please check your request"
        )
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationExceptions(
            ex: MethodArgumentNotValidException): Map<String, String?> {
        val errors: MutableMap<String, String?> = HashMap()
        ex.bindingResult.allErrors.forEach(Consumer { error: ObjectError ->
            val fieldName = (error as FieldError).field
            val errorMessage = error.getDefaultMessage()
            errors[fieldName] = errorMessage
        })
        return errors
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException::class)
    fun bindException(ex: BindException): WebResponse<String> {
        return WebResponse(
                code = 500,
                status = "BAD REQUEST",
                data = "Please check your request"
        )
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoHandlerFoundException::class)
    fun noHandlerFound(ex: NoHandlerFoundException): WebResponse<String> {
        return WebResponse(
                code = 404,
                status = "NOT FOUND",
                data = "Please check your request"
        )
    }

    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    @ExceptionHandler(AsyncRequestTimeoutException::class)
    fun asyncRequestTimeout(ex: AsyncRequestTimeoutException): WebResponse<String> {
        return WebResponse(
                code = 503,
                status = "SERVICE UNAVAILABLE",
                data = "Please check your request"
        )
    }

}