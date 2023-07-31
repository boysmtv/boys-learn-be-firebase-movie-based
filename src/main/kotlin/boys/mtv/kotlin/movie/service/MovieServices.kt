package boys.mtv.kotlin.movie.service

import boys.mtv.kotlin.movie.model.ListProductRequest
import boys.mtv.kotlin.movie.model.ProductRequest
import boys.mtv.kotlin.movie.model.ProductResponse
import boys.mtv.kotlin.movie.model.UpdateProductRequest
import boys.mtv.kotlin.movie.model.movie.*

interface MovieServices {

    fun register(model: RegisterRequest) : RegisterResponse

    fun login(model: LoginRequest) : LoginResponse

    fun getProfile(model: ProfileRequest) : ProfileResponse

}