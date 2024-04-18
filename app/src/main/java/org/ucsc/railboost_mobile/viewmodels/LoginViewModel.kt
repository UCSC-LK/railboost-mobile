package org.ucsc.railboost_mobile.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.ucsc.railboost_mobile.data.LoginResponseDTO
import org.ucsc.railboost_mobile.repository.LoginRepo
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginRepo: LoginRepo
) : ViewModel() {

    fun onLoginButtonClick(username: String, password: String) {
        loginRepo.signin(username, password, this)
    }


    fun onLoginSuccess(loginResp: LoginResponseDTO) {
        Log.d("login", loginResp.username)
        Log.d("login", loginResp.role.toString())
        Log.d("login", loginResp.jwt)
    }
}