package org.ucsc.railboost_mobile.repository

import android.util.Log
import org.ucsc.railboost_mobile.api.RetrofitInstance
import org.ucsc.railboost_mobile.data.LoginRequestDTO
import org.ucsc.railboost_mobile.data.LoginResponseDTO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.log

class LoginRepo {
    fun signin(username: String, password: String) {
        val loginReq = LoginRequestDTO(username, password)
        RetrofitInstance.loginApi.login(loginReq).enqueue(object: Callback<LoginResponseDTO> {
            override fun onResponse(
                call: Call<LoginResponseDTO>,
                response: Response<LoginResponseDTO>
            ) {
                val isSuccessful = response.isSuccessful

                val loginResp: LoginResponseDTO? = response.body()
                if (isSuccessful && loginResp!=null) {
                    Log.d("login", loginResp.username)
                    Log.d("login", loginResp.role.toString())
                    Log.d("login", loginResp.jwt)
                }
                Log.d("login", response.body().toString())
            }

            override fun onFailure(call: Call<LoginResponseDTO>, t: Throwable) {
                t.message?.let { Log.d("login", it) }
            }

        })
    }
}