package com.siar.demofeatures.data

import com.siar.demofeatures.data.model.UserModel

/*****
 * Project: Demo Features
 * Created by: Pablo Daniel Quiroga
 * Since: 20/01/2024
 *
 * All rights reserved 2024.
 *****/
data class User(
    val user: String,
    val pass: String
)

fun UserModel.toDomain() = User(user, pass)
