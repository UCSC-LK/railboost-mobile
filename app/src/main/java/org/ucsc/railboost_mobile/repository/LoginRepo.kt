package org.ucsc.railboost_mobile.repository

import android.util.Log
import org.ucsc.railboost_mobile.api.LoginAPI
import org.ucsc.railboost_mobile.api.RetrofitInstance
import org.ucsc.railboost_mobile.data.LoginRequestDTO
import org.ucsc.railboost_mobile.data.LoginResponseDTO
import org.ucsc.railboost_mobile.viewmodels.LoginViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class LoginRepo @Inject constructor(
    private val loginApi: LoginAPI
) {
    fun signin(username: String, password: String, loginViewModel: LoginViewModel) {
        val loginReq = LoginRequestDTO(username, password)

//        val loginResp = loginApi.login(loginReq)


//        RetrofitInstance.loginApi.login(loginReq).enqueue(object: Callback<LoginResponseDTO> {
//            override fun onResponse(
//                call: Call<LoginResponseDTO>,
//                response: Response<LoginResponseDTO>
//            ) {
//                val isSuccessful = response.isSuccessful
//
//                val loginResp = response.body()
//                if (isSuccessful && loginResp!=null) {
//                    loginViewModel.onLoginSuccess(loginResp)
//                }
//                Log.d("login", response.body().toString())
//            }
//
//            override fun onFailure(call: Call<LoginResponseDTO>, t: Throwable) {
//                t.message?.let { Log.d("login", it) }
//            }
//        })
    }

    suspend fun login(username: String, password: String): Response<LoginResponseDTO> {
        val loginReq = LoginRequestDTO(username, password)
        return loginApi.login(loginReq)
    }
}