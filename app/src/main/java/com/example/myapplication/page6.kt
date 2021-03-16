package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.net.HttpURLConnection
import java.net.URL

class page6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page6)

        fun startPostRequest() {
            // Bodyのデータ（サンプル）
            val sendDataJson = "{\"event\":\"mercy\"}"
            val bodyData = sendDataJson.toByteArray()

            // HttpURLConnectionの作成
            val url = URL("ここにURL")
            val connection = url.openConnection() as HttpURLConnection
            try {
                // ミリ秒単位でタイムアウトを設定
                //connection.connectTimeout = CONNECTION_TIMEOUT_MILLISECONDS
                //connection.readTimeout = READ_TIMEOUT_MILLISECONDS

//        connection.requestMethod = "POST"
                // Bodyへ書き込むを行う
                connection.doOutput = true

                // リクエストBodyのストリーミング有効化（どちらか片方を有効化）
//        connection.setFixedLengthStreamingMode(bodyData.size)
                connection.setChunkedStreamingMode(0)

                // プロパティの設定
                connection.setRequestProperty("Content-type", "application/json; charset=utf-8")

//        connection.connect()

                // Bodyの書き込み
                val outputStream = connection.outputStream
                outputStream.write(bodyData)
                outputStream.flush()
                outputStream.close()

                // Responseの読み出し
                val statusCode = connection.responseCode
                if (statusCode == HttpURLConnection.HTTP_OK) {
                    (connection.inputStream)
                }
            } catch (exception: Exception) {
                Log.e("Error", exception.toString())
            } finally {
                connection.disconnect()
            }
        }
    }
}