package com.example.kotlin_databinding_basic.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin_databinding_basic.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}