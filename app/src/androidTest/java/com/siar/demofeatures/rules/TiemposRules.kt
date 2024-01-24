package com.siar.demofeatures.rules

import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

/*****
 * Project: Demo Features
 * Created by: Pablo Daniel Quiroga
 * Since: 24/01/2024
 *
 * All rights reserved 2024.
 *****/
annotation class LogTiempos

class TiemposRules: TestRule {
    override fun apply(base: Statement?, description: Description?): Statement {
        return object: Statement(){
            override fun evaluate() {
                val anotado = description
                    ?.annotations
                    ?.filterIsInstance<LogTiempos>()
                    ?.isNotEmpty()
                val inicio = System.currentTimeMillis()
                try{
                    base?.evaluate()
                } finally {
                    val final = System.currentTimeMillis()

                    if (anotado == true) {
                        println("${description.methodName} ha tardado: ${final - inicio} ms")
                    }
                }
            }

        }
    }
}