package com.siar.demofeatures.login

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/*****
 * Project: Demo Features
 * Created by: Pablo Daniel Quiroga
 * Since: 17/01/2024
 *
 * All rights reserved 2024.
 *****/
class LoginViewModel: ViewModel() {

    private var _loginEnabled: MutableLiveData<Boolean> = MutableLiveData(false)
    val loginEnabled: LiveData<Boolean> = _loginEnabled

    private lateinit var user: String
    private lateinit var pass: String
    private var mail = false
    private var psw = false

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
        Toast.makeText(context, user, Toast.LENGTH_SHORT).show()
    }
}