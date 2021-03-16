package com.example.myapplication

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_page8.*
import org.json.JSONException
import org.json.JSONObject
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL

class page8 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page8)

        val bundle = intent.extras
        val date_data: String? = bundle?.getString("date")

        val str_url: String? = date_data



        //ボタンがクリックされたらAPIを叩く。
        /*
        HitAPITask().execute("https://beginners-hack-demo2.herokuapp.com/" + str_url)
        HitAPITask2().execute("https://beginners-hack-demo2.herokuapp.com/" + str_url)
        HitAPITask3().execute("https://beginners-hack-demo2.herokuapp.com/" +str_url)
        HitAPITask4().execute("https://beginners-hack-demo2.herokuapp.com/" +str_url)
        HitAPITask5().execute("https://beginners-hack-demo2.herokuapp.com/" +str_url)
        */

        HitAPITask().execute("https://jsondata.okiba.me/v1/json/zHEKx210316132619")
        HitAPITask2().execute("https://jsondata.okiba.me/v1/json/zHEKx210316132619")
        HitAPITask3().execute("https://jsondata.okiba.me/v1/json/zHEKx210316132619")
        HitAPITask4().execute("https://jsondata.okiba.me/v1/json/zHEKx210316132619")
        HitAPITask5().execute("https://jsondata.okiba.me/v1/json/zHEKx210316132619")



    }

    inner class HitAPITask : AsyncTask<String, String, String>() {

        override fun doInBackground(vararg params: String?): String? {
            //ここでAPIを叩きます。バックグラウンドで処理する内容です。
            var connection: HttpURLConnection? = null
            var reader: BufferedReader? = null
            val buffer: StringBuffer

            try {
                //param[0]にはAPIのURI(String)を入れます(後ほど)。
                //AsynkTask<...>の一つめがStringな理由はURIをStringで指定するからです。
                val url = URL(params[0])
                connection = url.openConnection() as HttpURLConnection
                connection.connect()  //ここで指定したAPIを叩いてみてます。

                //ここから叩いたAPIから帰ってきたデータを使えるよう処理していきます。

                //とりあえず取得した文字をbufferに。
                val stream = connection.inputStream
                reader = BufferedReader(InputStreamReader(stream))
                buffer = StringBuffer()
                var line: String?
                while (true) {
                    line = reader.readLine()
                    if (line == null) {
                        break
                    }
                    buffer.append(line)
                    //Log.d("CHECK", buffer.toString())
                }

                //ここからは、今回はJSONなので、いわゆるJsonをParseする作業（Jsonの中の一つ一つのデータを取るような感じ）をしていきます。

                //先ほどbufferに入れた、取得した文字列
                val jsonText = buffer.toString()

                //JSONObjectを使って、まず全体のJSONObjectを取ります。
                val parentJsonObj = JSONObject(jsonText)
                //今回のJSONは配列になっているので（データは一つですが）、全体のJSONObjectから、getJSONArrayで配列"movies"を取ります。
                val parentJsonArray = parentJsonObj.getJSONArray("data")

                //JSONArrayの中身を取ります。映画"Your Name"のデータは、配列"movies"の０番目のデータなので、
                val detailJsonObj = parentJsonArray.getJSONObject(0)  //これもJSONObjectとして取得

                //moviesの0番目のデータのtitle項目をStringで取ります。これで中身を取れました。
                val movieName: String = detailJsonObj.getString("TITLE")  // => Your Name.


                //Stringでreturnしてあげましょう。
                return "$movieName"  // => Your Name. - 2016

                //ここから下は、接続エラーとかJSONのエラーとかで失敗した時にエラーを処理する為のものです。
            } catch (e: MalformedURLException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            } catch (e: JSONException) {
                e.printStackTrace()
            }
            //finallyで接続を切断してあげましょう。
            finally {
                connection?.disconnect()
                try {
                    reader?.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
            //失敗した時はnullやエラーコードなどを返しましょう。
            return null
        }


        //返ってきたデータをビューに反映させる処理はonPostExecuteに書きます。これはメインスレッドです。
        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            if (result == null) return

            textView_title.text = result
        }
    }

    inner class HitAPITask2 : AsyncTask<String, String, String>() {

        override fun doInBackground(vararg params: String?): String? {
            //ここでAPIを叩きます。バックグラウンドで処理する内容です。
            var connection: HttpURLConnection? = null
            var reader: BufferedReader? = null
            val buffer: StringBuffer

            try {
                //param[0]にはAPIのURI(String)を入れます(後ほど)。
                //AsynkTask<...>の一つめがStringな理由はURIをStringで指定するからです。
                val url = URL(params[0])
                connection = url.openConnection() as HttpURLConnection
                connection.connect()  //ここで指定したAPIを叩いてみてます。

                //ここから叩いたAPIから帰ってきたデータを使えるよう処理していきます。

                //とりあえず取得した文字をbufferに。
                val stream = connection.inputStream
                reader = BufferedReader(InputStreamReader(stream))
                buffer = StringBuffer()
                var line: String?
                while (true) {
                    line = reader.readLine()
                    if (line == null) {
                        break
                    }
                    buffer.append(line)
                    //Log.d("CHECK", buffer.toString())
                }

                //ここからは、今回はJSONなので、いわゆるJsonをParseする作業（Jsonの中の一つ一つのデータを取るような感じ）をしていきます。

                //先ほどbufferに入れた、取得した文字列
                val jsonText = buffer.toString()

                //JSONObjectを使って、まず全体のJSONObjectを取ります。
                val parentJsonObj = JSONObject(jsonText)
                //今回のJSONは配列になっているので（データは一つですが）、全体のJSONObjectから、getJSONArrayで配列"movies"を取ります。
                val parentJsonArray = parentJsonObj.getJSONArray("data")

                //JSONArrayの中身を取ります。映画"Your Name"のデータは、配列"movies"の０番目のデータなので、
                val detailJsonObj = parentJsonArray.getJSONObject(0)  //これもJSONObjectとして取得

                //moviesの0番目のデータのtitle項目をStringで取ります。これで中身を取れました。
                val movieName: String = detailJsonObj.getString("PLACE")  // => Your Name.


                //Stringでreturnしてあげましょう。
                return "$movieName"  // => Your Name. - 2016

                //ここから下は、接続エラーとかJSONのエラーとかで失敗した時にエラーを処理する為のものです。
            } catch (e: MalformedURLException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            } catch (e: JSONException) {
                e.printStackTrace()
            }
            //finallyで接続を切断してあげましょう。
            finally {
                connection?.disconnect()
                try {
                    reader?.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
            //失敗した時はnullやエラーコードなどを返しましょう。
            return null
        }


        //返ってきたデータをビューに反映させる処理はonPostExecuteに書きます。これはメインスレッドです。
        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            if (result == null) return

            place_view.text = result
        }
    }


    //  placeviewに表示する
    inner class HitAPITask3 : AsyncTask<String, String, String>() {

        override fun doInBackground(vararg params: String?): String? {
            //ここでAPIを叩きます。バックグラウンドで処理する内容です。
            var connection: HttpURLConnection? = null
            var reader: BufferedReader? = null
            val buffer: StringBuffer

            try {
                //param[0]にはAPIのURI(String)を入れます(後ほど)。
                //AsynkTask<...>の一つめがStringな理由はURIをStringで指定するからです。
                val url = URL(params[0])
                connection = url.openConnection() as HttpURLConnection
                connection.connect()  //ここで指定したAPIを叩いてみてます。

                //ここから叩いたAPIから帰ってきたデータを使えるよう処理していきます。

                //とりあえず取得した文字をbufferに。
                val stream = connection.inputStream
                reader = BufferedReader(InputStreamReader(stream))
                buffer = StringBuffer()
                var line: String?
                while (true) {
                    line = reader.readLine()
                    if (line == null) {
                        break
                    }
                    buffer.append(line)
                    //Log.d("CHECK", buffer.toString())
                }

                //ここからは、今回はJSONなので、いわゆるJsonをParseする作業（Jsonの中の一つ一つのデータを取るような感じ）をしていきます。

                //先ほどbufferに入れた、取得した文字列
                val jsonText = buffer.toString()

                //JSONObjectを使って、まず全体のJSONObjectを取ります。
                val parentJsonObj = JSONObject(jsonText)
                //今回のJSONは配列になっているので（データは一つですが）、全体のJSONObjectから、getJSONArrayで配列"movies"を取ります。
                val parentJsonArray = parentJsonObj.getJSONArray("data")

                //JSONArrayの中身を取ります。映画"Your Name"のデータは、配列"movies"の０番目のデータなので、
                val detailJsonObj = parentJsonArray.getJSONObject(0)  //これもJSONObjectとして取得


                val movieName: String = detailJsonObj.getString("DATE")
                val movieName2: String = detailJsonObj.getString("DAY")
                val movieName3: String = detailJsonObj.getString("FROM_TIME")
                val movieName4: String = detailJsonObj.getString("END_TIME")



                //Stringでreturnしてあげましょう。
                return "$movieName $movieName2 $movieName3 ~ $movieName4"  // => Your Name. - 2016

                //ここから下は、接続エラーとかJSONのエラーとかで失敗した時にエラーを処理する為のものです。
            } catch (e: MalformedURLException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            } catch (e: JSONException) {
                e.printStackTrace()
            }
            //finallyで接続を切断してあげましょう。
            finally {
                connection?.disconnect()
                try {
                    reader?.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
            //失敗した時はnullやエラーコードなどを返しましょう。
            return null
        }


        //返ってきたデータをビューに反映させる処理はonPostExecuteに書きます。これはメインスレッドです。
        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            if (result == null) return

            kyoka_view.text = result
        }
    }

    inner class HitAPITask4 : AsyncTask<String, String, String>() {

        override fun doInBackground(vararg params: String?): String? {
            //ここでAPIを叩きます。バックグラウンドで処理する内容です。
            var connection: HttpURLConnection? = null
            var reader: BufferedReader? = null
            val buffer: StringBuffer

            try {
                //param[0]にはAPIのURI(String)を入れます(後ほど)。
                //AsynkTask<...>の一つめがStringな理由はURIをStringで指定するからです。
                val url = URL(params[0])
                connection = url.openConnection() as HttpURLConnection
                connection.connect()  //ここで指定したAPIを叩いてみてます。

                //ここから叩いたAPIから帰ってきたデータを使えるよう処理していきます。

                //とりあえず取得した文字をbufferに。
                val stream = connection.inputStream
                reader = BufferedReader(InputStreamReader(stream))
                buffer = StringBuffer()
                var line: String?
                while (true) {
                    line = reader.readLine()
                    if (line == null) {
                        break
                    }
                    buffer.append(line)
                    //Log.d("CHECK", buffer.toString())
                }

                //ここからは、今回はJSONなので、いわゆるJsonをParseする作業（Jsonの中の一つ一つのデータを取るような感じ）をしていきます。

                //先ほどbufferに入れた、取得した文字列
                val jsonText = buffer.toString()

                //JSONObjectを使って、まず全体のJSONObjectを取ります。
                val parentJsonObj = JSONObject(jsonText)
                //今回のJSONは配列になっているので（データは一つですが）、全体のJSONObjectから、getJSONArrayで配列"movies"を取ります。
                val parentJsonArray = parentJsonObj.getJSONArray("data")

                //JSONArrayの中身を取ります。映画"Your Name"のデータは、配列"movies"の０番目のデータなので、
                val detailJsonObj = parentJsonArray.getJSONObject(0)  //これもJSONObjectとして取得

                //moviesの0番目のデータのtitle項目をStringで取ります。これで中身を取れました。
                val movieName: String = detailJsonObj.getString("MEMO")  // => Your Name.


                //Stringでreturnしてあげましょう。
                return "$movieName"  // => Your Name. - 2016

                //ここから下は、接続エラーとかJSONのエラーとかで失敗した時にエラーを処理する為のものです。
            } catch (e: MalformedURLException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            } catch (e: JSONException) {
                e.printStackTrace()
            }
            //finallyで接続を切断してあげましょう。
            finally {
                connection?.disconnect()
                try {
                    reader?.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
            //失敗した時はnullやエラーコードなどを返しましょう。
            return null
        }


        //返ってきたデータをビューに反映させる処理はonPostExecuteに書きます。これはメインスレッドです。
        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            if (result == null) return

            //place_view.text = result
        }
    }

    inner class HitAPITask5 : AsyncTask<String, String, String>() {

        override fun doInBackground(vararg params: String?): String? {
            //ここでAPIを叩きます。バックグラウンドで処理する内容です。
            var connection: HttpURLConnection? = null
            var reader: BufferedReader? = null
            val buffer: StringBuffer

            try {
                //param[0]にはAPIのURI(String)を入れます(後ほど)。
                //AsynkTask<...>の一つめがStringな理由はURIをStringで指定するからです。
                val url = URL(params[0])
                connection = url.openConnection() as HttpURLConnection
                connection.connect()  //ここで指定したAPIを叩いてみてます。

                //ここから叩いたAPIから帰ってきたデータを使えるよう処理していきます。

                //とりあえず取得した文字をbufferに。
                val stream = connection.inputStream
                reader = BufferedReader(InputStreamReader(stream))
                buffer = StringBuffer()
                var line: String?
                while (true) {
                    line = reader.readLine()
                    if (line == null) {
                        break
                    }
                    buffer.append(line)
                    //Log.d("CHECK", buffer.toString())
                }

                //ここからは、今回はJSONなので、いわゆるJsonをParseする作業（Jsonの中の一つ一つのデータを取るような感じ）をしていきます。

                //先ほどbufferに入れた、取得した文字列
                val jsonText = buffer.toString()

                //JSONObjectを使って、まず全体のJSONObjectを取ります。
                val parentJsonObj = JSONObject(jsonText)
                //今回のJSONは配列になっているので（データは一つですが）、全体のJSONObjectから、getJSONArrayで配列"movies"を取ります。
                val parentJsonArray = parentJsonObj.getJSONArray("data")

                //JSONArrayの中身を取ります。映画"Your Name"のデータは、配列"movies"の０番目のデータなので、
                val detailJsonObj = parentJsonArray.getJSONObject(0)  //これもJSONObjectとして取得

                //moviesの0番目のデータのtitle項目をStringで取ります。これで中身を取れました。
                val movieName: String = detailJsonObj.getString("URL")  // => Your Name.

                //Stringでreturnしてあげましょう。
                return "$movieName"  // => Your Name. - 2016

                //ここから下は、接続エラーとかJSONのエラーとかで失敗した時にエラーを処理する為のものです。
            } catch (e: MalformedURLException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            } catch (e: JSONException) {
                e.printStackTrace()
            }
            //finallyで接続を切断してあげましょう。
            finally {
                connection?.disconnect()
                try {
                    reader?.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
            //失敗した時はnullやエラーコードなどを返しましょう。
            return null
        }


        //返ってきたデータをビューに反映させる処理はonPostExecuteに書きます。これはメインスレッドです。
        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            if (result == null) return

            //editTextTextPersonName5.text = result
        }
    }




}