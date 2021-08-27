package com.example.appbar_inflearn_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appbar_inflearn_test.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binder : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binder = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binder.root)
        
        setSupportActionBar(binder.toolbar)
    }
}