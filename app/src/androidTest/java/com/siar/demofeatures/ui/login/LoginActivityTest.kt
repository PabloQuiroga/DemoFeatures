package com.siar.demofeatures.ui.login

import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.siar.demofeatures.R
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/*****
 * Project: Demo Features
 * Created by: Pablo Daniel Quiroga
 * Since: 24/01/2024
 *
 * All rights reserved 2024.
 */
@RunWith(AndroidJUnit4::class)
class LoginActivityTest{

    @Before
    fun beforeTest(){
        // necesario para crear el activity antes de testear elementos
        val escenario = launchActivity<LoginActivity>()
    }

    @Test
    fun checkTextTitle(){
        //val escenario = launchActivity<LoginActivity>()
        val expected = "Iniciar sesion"
        onView(withId(R.id.lbl_Login)).check(matches(withText(expected)))
    }

    @Test
    fun checkEditMail(){
        val email = "asd@asd.com"
        onView(withId(R.id.ed_mail)).perform(typeText(email))
    }

}