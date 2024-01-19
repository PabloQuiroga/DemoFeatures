package com.siar.demofeatures.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.siar.demofeatures.R
import com.siar.demofeatures.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}