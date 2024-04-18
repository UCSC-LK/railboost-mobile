package org.ucsc.railboost_mobile.ui.screens

import android.util.Log
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.ucsc.railboost_mobile.R
import org.ucsc.railboost_mobile.api.RetrofitInstance
import org.ucsc.railboost_mobile.data.LoginRequestDTO
import org.ucsc.railboost_mobile.data.LoginResponseDTO
import org.ucsc.railboost_mobile.rememberImeState
import org.ucsc.railboost_mobile.repository.LoginRepo
import org.ucsc.railboost_mobile.ui.theme.RailBoostTheme
import org.ucsc.railboost_mobile.viewmodels.LoginViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun Signin(
    modifier: Modifier = Modifier,
    loginViewModel: LoginViewModel = LoginViewModel()
) {
    val loginRepo = LoginRepo()

    val isImeVisible by rememberImeState()

    Column(
        modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        RailBoostLogo(isImeVisible = isImeVisible)
        Spacer(modifier = Modifier.height(10.dp))
        LoginInput(loginRepo = loginRepo, loginViewModel = loginViewModel)
    }
}


@Composable
fun RailBoostLogo(modifier: Modifier = Modifier, isImeVisible: Boolean) {
    val animatedLogoHide by animateFloatAsState(
        targetValue = if (isImeVisible) 0f else 0.35f,
        label = ""
    )
    Image(
        modifier = modifier.fillMaxHeight(animatedLogoHide),
        painter = painterResource(id = R.drawable.logo),
        contentDescription = null
    )
}


@Composable
fun LoginInput(modifier: Modifier = Modifier, loginRepo: LoginRepo, loginViewModel: LoginViewModel) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier.fillMaxSize(0.8f),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = username,
            onValueChange = {username = it},
            label = { Text(text = "Username") },
            singleLine = true
        )
        TextField(
            modifier = modifier.fillMaxWidth(),
            value = password,
            onValueChange = {password = it},
            label = { Text(text = "Password") },
            visualTransformation = PasswordVisualTransformation(),
            singleLine = true
        )
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = {
//                loginRepo.signin(username, password)
                loginViewModel.onLoginButtonClick(username, password)
            },
            Modifier.fillMaxWidth()
        ) {
            Text(text = "Login")
        }
    }
}