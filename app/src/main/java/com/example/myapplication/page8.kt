package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_page8.*

class page8 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page8)

        button_openpage9frompage8.setOnClickListener{
            intent = Intent(this@page8,page9::class.java)
            startActivity(intent)
        }





    }


}