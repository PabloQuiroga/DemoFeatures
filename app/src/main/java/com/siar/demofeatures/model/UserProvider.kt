package com.siar.demofeatures.model

/*****
 * Project: Demo Features
 * Created by: Pablo Daniel Quiroga
 * Since: 18/01/2024
 *
 * More info:
 *
 * All rights reserved 2024.
 *****/
class UserProvider {
    companion object {
        fun getUser(): User{
            return user
        }

        private val user = User("jtdoe78@gmail.com", "1234")
    }
}