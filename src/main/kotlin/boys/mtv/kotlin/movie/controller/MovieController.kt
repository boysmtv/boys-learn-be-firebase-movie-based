package boys.mtv.kotlin.movie.controller

import boys.mtv.kotlin.movie.model.*
import boys.mtv.kotlin.movie.service.MovieServices
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@Validated
class MovieController(val services: MovieServices) {

    @PostMapping(
            value = ["/api/movie/register"],
            consumes = ["application/json"],
            produces = ["application/json"]
    )
    fun register(@RequestBody body: RegisterRequest): WebResponse<RegisterResponse> {
        return WebResponse(
                code = 200,
                status = "OK",
                services.register(body)
        )
    }


    @PostMapping(
            value = ["/api/movie/login"],
            consumes = ["application/json"],
            produces = ["application/json"]
    )
    fun login(@RequestBody body: LoginRequest): WebResponse<LoginResponse> {
        return WebResponse(
                code = 200,
                status = "OK",
                services.login(body)
        )
    }

    @PostMapping(
            value = ["/api/movie/profile"],
            consumes = ["application/json"],
            produces = ["application/json"]
    )
    fun getProfile(@RequestBody body: ProfileRequest): WebResponse<ProfileResponse> {
        return WebResponse(
                code = 200,
                status = "OK",
                services.getProfile(body)
        )
    }

}