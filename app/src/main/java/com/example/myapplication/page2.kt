package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_page2.*

class page2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page2)

        calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            val date_page2:String =dayOfMonth.toString()
            val dateful_page2:String = "" +  month + "月" + dayOfMonth + "日"
            val intent = Intent(this@page2,page5::class.java)
            intent.putExtra("date_page2",date_page2)
            intent.putExtra("datefull_page2",dateful_page2)
            startActivity(intent)
        }
    }
}