package com.siar.demofeatures.ui.utils

import android.util.Patterns

/*****
 * Project: Demo Features
 * Created by: Pablo Daniel Quiroga
 * Since: 18/01/2024
 *
 * Field validations
 *
 * All rights reserved 2024.
 *****/
class ValidationModel(val isValid: Boolean, val message: String)

fun String.validateEmail(): ValidationModel {
    return if (this.trim().isEmpty()) {
        ValidationModel(false, "Email should not Empty")
    } else if (!Patterns.EMAIL_ADDRESS.matcher(this).matches()) {
        ValidationModel(false, "Email format is wrong")
    } else {
        ValidationModel(true, "")
    }
}

fun String.validatePassword(): ValidationModel {
    val pattern = "[0-9]".toRegex()
    val pattern2 = "[a-z]|[A-Z]".toRegex()

    return if (this.isEmpty()) {
        ValidationModel(false, "Password should not empty")
    } else if (this.length < 5) {
        ValidationModel(false, "Minimal 5 character")
    } else if (!pattern.containsMatchIn(this) || !pattern2.containsMatchIn(this)) {
        ValidationModel(false, "Require combination number and text")
    } else {
        ValidationModel(true, "")
    }
}