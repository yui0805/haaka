package com.example.myapplication


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.button_openpage9frompage8
import kotlinx.android.synthetic.main.activity_page6.*




class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        HitAPITask().execute("https://beginners-hack-demo2.herokuapp.com/sample_TimeTable")
//        HitAPITask2().execute("https://jsondata.okiba.me/v1/json/RV6fn210316161358")
//        HitAPITask3().execute("https://jsondata.okiba.me/v1/json/RV6fn210316161358")
//        HitAPITask4().execute("https://jsondata.okiba.me/v1/json/RV6fn210316161358")
//        HitAPITask5().execute("https://jsondata.okiba.me/v1/json/RV6fn210316161358")
//        HitAPITask6().execute("https://jsondata.okiba.me/v1/json/RV6fn210316161358")
//        HitAPITask7().execute("https://jsondata.okiba.me/v1/json/RV6fn210316161358")
//        HitAPITask8().execute("https://jsondata.okiba.me/v1/json/RV6fn210316161358")
//        HitAPITask9().execute("https://jsondata.okiba.me/v1/json/RV6fn210316161358")
//        HitAPITask10().execute("https://jsondata.okiba.me/v1/json/RV6fn210316161358")







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






    button9.setOnClickListener {
        val intent = Intent(this@MainActivity, page4::class.java)
        startActivity(intent)
    }



        button6.setOnClickListener {
            val intent = Intent(this@MainActivity, page5::class.java)
            startActivity(intent)
        }

        button_openpage9frompage8.setOnClickListener {
            val intent = Intent(this@MainActivity, page6::class.java)
            startActivity(intent)
        }

        button20.setOnClickListener {
            val intent = Intent(this@MainActivity,page3::class.java)
            startActivity(intent)
        }

        button13.setOnClickListener {
            val intent = Intent(this@MainActivity, page9::class.java)
            intent.putExtra("date", day)
            startActivity(intent)
        }

        button16.setOnClickListener {
            val intent = Intent(this@MainActivity,page2::class.java)

            startActivity(intent)
        }







    }




}