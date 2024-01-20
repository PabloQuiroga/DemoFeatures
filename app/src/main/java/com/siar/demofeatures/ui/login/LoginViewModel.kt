package com.siar.demofeatures.ui.login

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.siar.demofeatures.data.LoginRepository
import com.siar.demofeatures.ui.utils.validateEmail
import com.siar.demofeatures.ui.utils.validatePassword
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*****
 * Project: Demo Features
 * Created by: Pablo Daniel Quiroga
 * Since: 17/01/2024
 *
 * All rights reserved 2024.
 *****/
class LoginViewModel: ViewModel() {
    private val repository = LoginRepository()

    private var _loginEnabled: MutableLiveData<Boolean> = MutableLiveData(false)
    val loginEnabled: LiveData<Boolean> = _loginEnabled

    private lateinit var user: String
    private lateinit var pass: String
    private var mail = false
    private var psw = false
    private var message = ""

    fun validateUser(u: String){
        if (u.trim().isNotEmpty()) {
            user = u
            mail = true
        }
        _loginEnabled.postValue(mail && psw)
    }
    fun validatePass(p: String){
        if (p.trim().isNotEmpty()) {
            pass = p
            psw = true
        }
        _loginEnabled.postValue(mail && psw)
    }

    fun onLoginVerify(context: Context){
        val userValidate = user.validateEmail()
        val passValidate = pass.validatePassword()
        val errorMessage = userValidate.message + "\n" + passValidate.message


        message = if(userValidate.isValid && passValidate.isValid){
            checkUser(user)
        } else errorMessage

        showMessage(message, context)
    }

     private fun checkUser(user: String): String {
        return runBlocking {
            async {
                val userApi = repository.getUserFromApi()
                if(user == userApi.user) {
                    return@async "usuario correcto"
                } else {
                    return@async "usuario incorrecto"
                }
            }.await()
        }
    }

    private fun showMessage(message: String, context: Context){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}