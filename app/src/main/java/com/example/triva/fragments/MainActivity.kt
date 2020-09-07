package com.example.triva.fragments

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.triva.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
    }
}