package org.ucsc.railboost_mobile.api

import org.ucsc.railboost_mobile.data.LoginRequestDTO
import org.ucsc.railboost_mobile.data.LoginResponseDTO
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST


interface  LoginAPI {
    @POST("login")
    suspend fun login(@Body loginReq: LoginRequestDTO) : Response<LoginResponseDTO>
}
