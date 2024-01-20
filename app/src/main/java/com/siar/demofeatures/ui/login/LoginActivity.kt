package com.siar.demofeatures.ui.login

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Observer
import com.siar.demofeatures.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater).apply {
            composeView.setContent {
                // You're in Compose world!
                MaterialTheme {
                    PlantDetailDescription()
                }
            }
        }
        setContentView(binding.root)

        handleInputs()
        loginViewModel.loginEnabled.observe(this, Observer {
            binding.btnLogin.isEnabled = it
        })
        binding.btnLogin.setOnClickListener{
            login()
        }
    }

    private fun handleInputs(){
        val mailEd: EditText = binding.edMail
        val passwordEd: EditText = binding.edPass

        mailEd.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Log.e("beforeTextChanged", "beforeTextChanged: null")
            }
            override fun afterTextChanged(p0: Editable?) {
                Log.e("afterTextChanged", "afterTextChanged: null")
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                loginViewModel.validateUser(mailEd.text.toString())
            }
        })
        passwordEd.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Log.e("beforeTextChanged", "beforeTextChanged: null")
            }
            override fun afterTextChanged(p0: Editable?) {
                Log.e("afterTextChanged", "afterTextChanged: null")
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                loginViewModel.validatePass(passwordEd.text.toString())
            }
        })
    }

    private fun login(){
        loginViewModel.onLoginVerify(this)
    }
}

@Composable
fun PlantDetailDescription() {
    Surface {
        Text("Hello Compose")
    }
}

@Preview
@Composable
fun PreviewPlant(){
    PlantDetailDescription()
}