package boys.mtv.kotlin.movie.service

import boys.mtv.kotlin.movie.model.*

interface MovieServices {

    fun register(model: RegisterRequest) : RegisterResponse

    fun login(model: LoginRequest) : LoginResponse

    fun getProfile(model: ProfileRequest) : ProfileResponse

}