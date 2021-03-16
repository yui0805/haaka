package com.example.myapplication


import android.content.Intent
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*




class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var day: String = "0"

        /*

        MON1.setOnClickListener{
            day="MON"
        }
        MON2.setOnClickListener{
            day="MON"
        }
        MON3.setOnClickListener{
            day="MON"
        }
        MON4.setOnClickListener{
            day="MON"
        }
        MON5.setOnClickListener{
            day="MON"
        }

        TUE1.setOnClickListener{
            day="TUE"
        }
        TUE2.setOnClickListener{
            day="TUE"
        }
        TUE3.setOnClickListener{
            day="TUE"
        }
        TUE4.setOnClickListener{
            day="TUE"
        }
        TUE5.setOnClickListener{
            day="TUE"
        }

        WED1.setOnClickListener{
            day="WED"
        }
        WED2.setOnClickListener{
            day="WED"
        }
        WED3.setOnClickListener{
            day="WED"
        }
        WED4.setOnClickListener{
            day="WED"
        }
        WED5.setOnClickListener {
            day = "WED"
        }


        THU1.setOnClickListener{
            day="WED"
        }
        THU2.setOnClickListener{
            day="WED"
        }
        THU3.setOnClickListener{
            day="WED"
        }
        THU4.setOnClickListener{
            day="WED"
        }
        THU5.setOnClickListener{
            day="WED"
        }

        FRI1.setOnClickListener{
            day="WED"
        }
        FRI2.setOnClickListener{
            day="WED"
        }
        FRI3.setOnClickListener{
            day="WED"
        }
        FRI4.setOnClickListener{
            day="WED"
        }
        FRI5.setOnClickListener{
            day="WED"
        }
        */











        button6.setOnClickListener {
            val intent = Intent(this@MainActivity,page5::class.java)
            startActivity(intent)
        }

        button.setOnClickListener {
            val intent = Intent(this@MainActivity,page6::class.java)
            startActivity(intent)
        }

        button13.setOnClickListener {
            val intent = Intent(this@MainActivity,page8::class.java)
            intent.putExtra("date",day)
            startActivity(intent)
        }

    }
}