package com.siar.demofeatures.utils

import android.util.Log
import com.siar.demofeatures.ui.utils.validateEmail
import com.siar.demofeatures.ui.utils.validatePassword
import org.hamcrest.CoreMatchers.hasItem
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

/*****
 * Project: Demo Features
 * Created by: Pablo Daniel Quiroga
 * Since: 21/01/2024
 *
 * Info: Set in instrumented because
 *      class Android.Util.Patterns is needed.
 *      Add Hamcrest validations for list
 *
 * All rights reserved 2024.
 *****/
class ValidationsTest {

    val emailEmpty = ""
    val emailBlanck = " "
    val emailNoRegex = "asd@asd"
    val emailCorrect = "asd@asd.com"

    val passEmpty = ""
    val passLengthTwo = "a1"
    val passOnlyLetters = "asdasd"
    val passOnlyNumbers = "123123"
    val passCorrect = "asd123"

    val listEmail = listOf(emailEmpty, emailBlanck, emailNoRegex, emailCorrect)
    val listPass = listOf(passEmpty, passLengthTwo, passOnlyLetters, passOnlyNumbers, passCorrect)

    // Test emails
    @Test
    fun validateEmailEmpty(){
        assertFalse(emailEmpty.validateEmail().isValid)
    }
    @Test
    fun validateEmailBlanck(){
        assertFalse(emailBlanck.validateEmail().isValid)
    }
    @Test
    fun validateEmailNoRegex(){
        assertFalse(emailNoRegex.validateEmail().isValid)
    }
    @Test
    fun validateEmailCorrect(){
        assertTrue(emailCorrect.validateEmail().isValid)
    }
    @Test
    fun validateListEmails(){
        val validateEmails = mutableListOf<Boolean>()
        for (email in listEmail){
            validateEmails.add(email.validateEmail().isValid)
        }
        Log.i("validateListEmails","lista de emails a validar: \n$validateEmails")
        assertThat(validateEmails, hasItem(true))
        //val expected = listOf(false, false, false, true)
        //assertEquals(expected, validateEmails)
    }

    // Test passwords
    @Test
    fun validatePassEmpty(){
        assertFalse(passEmpty.validatePassword().isValid)
    }
    @Test
    fun validatePassLengthTwo(){
        assertFalse(passLengthTwo.validatePassword().isValid)
    }
    @Test
    fun validatePassOnlyLetters(){
        assertFalse(passOnlyLetters.validatePassword().isValid)
    }
    @Test
    fun validatePassOnlyNumbers(){
        assertFalse(passOnlyNumbers.validatePassword().isValid)
    }
    @Test
    fun validatePassCorrect(){
        assertTrue(passCorrect.validatePassword().isValid)
    }
    @Test
    fun validateListPasswords(){
        val validatePasswords = mutableListOf<Boolean>()
        for (pass in listPass){
            validatePasswords.add(pass.validatePassword().isValid)
        }
        Log.i("validateListPasswords","lista de passwords a validar: \n$validatePasswords")
        assertThat(validatePasswords, hasItem(true))
        //val expected = listOf(false, false, false, false, true)
        //assertEquals(expected, validatePasswords)
    }

}