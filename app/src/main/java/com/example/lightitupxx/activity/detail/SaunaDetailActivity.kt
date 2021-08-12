package com.example.lightitupxx.activity.detail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lightitupxx.R
import kotlinx.android.synthetic.main.activity_saunadetail.*

class SaunaDetailActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saunadetail)

        callsauna.setOnClickListener {
            var intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel: 02-465-4500")
            startActivity(intent)
        }
    }
}