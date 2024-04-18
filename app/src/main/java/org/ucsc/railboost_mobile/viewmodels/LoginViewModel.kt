package org.ucsc.railboost_mobile.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import org.ucsc.railboost_mobile.data.LoginResponseDTO
import org.ucsc.railboost_mobile.repository.LoginRepo

class LoginViewModel : ViewModel() {

    fun onLoginButtonClick(username: String, password: String) {
        val loginRepo = LoginRepo()
        loginRepo.signin(username, password, this)
    }


    fun onLoginSuccess(loginResp: LoginResponseDTO) {
        Log.d("login", loginResp.username)
        Log.d("login", loginResp.role.toString())
        Log.d("login", loginResp.jwt)
    }
}