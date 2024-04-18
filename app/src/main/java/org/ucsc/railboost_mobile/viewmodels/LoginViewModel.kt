package org.ucsc.railboost_mobile.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.ucsc.railboost_mobile.data.LoginResponseDTO
import org.ucsc.railboost_mobile.repository.LoginRepo
import org.ucsc.railboost_mobile.utils.DataStoreManager
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginRepo: LoginRepo,
    private val dataStoreManager: DataStoreManager
) : ViewModel() {

    fun onLoginButtonClick(username: String, password: String) {
        loginRepo.signin(username, password, this)
    }


    fun onLoginSuccess(loginResp: LoginResponseDTO) {
        saveUserInfo(loginResp)
        Log.d("login", loginResp.username)
        Log.d("login", loginResp.role.toString())
        Log.d("login", loginResp.jwt)
    }

    private fun saveUserInfo(loginResp: LoginResponseDTO) {
        viewModelScope.launch {
            dataStoreManager.setData("username", loginResp.username)
            dataStoreManager.setData("jwt", loginResp.jwt)
        }
    }
}