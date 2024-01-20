package com.siar.demofeatures.data.network

import com.siar.demofeatures.data.model.UserModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/*****
 * Project: Demo Features
 * Created by: Pablo Daniel Quiroga
 * Since: 20/01/2024
 *
 * All rights reserved 2024.
 *****/
class UserService {
    private val userMock = UserModel("jtdoe78@gmail.com", "1234")

    suspend fun getUser(): UserModel {
        return withContext(Dispatchers.IO) {
            val response = userMock
            response
        }
    }
}