package com.siar.demofeatures.data.network

import com.siar.demofeatures.data.model.UserModel
import org.junit.Assert.assertEquals
import org.junit.Test


/*****
 * Project: Demo Features
 * Created by: Pablo Daniel Quiroga
 * Since: 20/01/2024
 *
 * All rights reserved 2024.
 */
class UserServiceTest {

    @Test
    fun getUserCorrect() {
        val userModel = UserModel("jtdoe78@gmail.com", "1234")
        assertEquals("jtdoe78@gmail.com", userModel.user)
    }
}