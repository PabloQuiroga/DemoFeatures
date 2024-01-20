package com.siar.demofeatures.data

import com.siar.demofeatures.data.model.UserModel
import com.siar.demofeatures.data.network.UserService

/*****
 * Project: Demo Features
 * Created by: Pablo Daniel Quiroga
 * Since: 20/01/2024
 *
 * All rights reserved 2024.
 *****/
class LoginRepository {
    private val api = UserService()

    suspend fun getUserFromApi(): User {
        val response: UserModel = api.getUser()
        return response.toDomain()
    }
}