package com.ravimaurya.urjanext.presentation.auth

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ravimaurya.urjanext.domain.model.UserModel
import com.ravimaurya.urjanext.domain.repository.AuthenticationRepository
import com.ravimaurya.urjanext.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


sealed class CheckUserExistState {
    data object Loading : CheckUserExistState()
    data class Success(val data: Boolean) : CheckUserExistState()
    data class Error(val message: String) : CheckUserExistState()
}


sealed class UserAuthenticationState {
    data object Loading : UserAuthenticationState()
    data class Success(val data: UserModel) : UserAuthenticationState()
    data class Error(val message: String) : UserAuthenticationState()
}

// Authentication Event
sealed class AuthenticationEvents {
    data class CheckUserExist(val number: String, val email: String) : AuthenticationEvents()
    data class Register(val userModel: UserModel) : AuthenticationEvents()
    data class Login(val userModel: UserModel) : AuthenticationEvents()
}


@HiltViewModel
class AuthenticationViewModel
@Inject constructor(private val authenticationRepository: AuthenticationRepository): ViewModel() {

    private var _userAuthUserState = MutableStateFlow<UserAuthenticationState?>(null)
    val userAuthState = _userAuthUserState.asStateFlow()


    fun onEvent(events: AuthenticationEvents){
        when(events){
            is AuthenticationEvents.CheckUserExist -> checkUserExist()
            is AuthenticationEvents.Login -> login(events.userModel)
            is AuthenticationEvents.Register -> register(events.userModel)
        }
    }

    private fun checkUserExist() = viewModelScope.launch {
        authenticationRepository.checkUserExist()
    }

    private fun register(userModel: UserModel) = viewModelScope.launch{
        authenticationRepository.register(userModel)
            .collect{ result ->
                when(result){
                    is Resource.Error -> {
                        _userAuthUserState.update {
                            UserAuthenticationState.Error(result.message)
                        }
                        println("RegisterVM: Error: ${result.message}")
                    }
                    Resource.Loading -> {
                        _userAuthUserState.update {
                            UserAuthenticationState.Loading
                        }
                        println("RegisterVM: Loading...")
                    }
                    is Resource.Success -> {
                        _userAuthUserState.update {
                            UserAuthenticationState.Success(result.data)
                        }
                        println("RegisterVM: Success: ${result.data}")
                    }
                }
            }
    }

    private fun login(userModel: UserModel) = viewModelScope.launch {
        authenticationRepository.login(userModel)
            .collect{ result ->
                when(result){
                    is Resource.Error -> {
                        _userAuthUserState.update {
                            UserAuthenticationState.Error(result.message)
                        }
                            println("LoginVM: Error: ${result.message}")
                    }
                    Resource.Loading -> {
                        _userAuthUserState.update {
                            UserAuthenticationState.Loading
                        }
                            println("LoginVM: Loading...")
                    }
                    is Resource.Success -> {
                        _userAuthUserState.update {
                            UserAuthenticationState.Success(result.data)
                        }
                            println("LoginVM: Success: ${result.data}")
                    }
                }
            }
    }


}