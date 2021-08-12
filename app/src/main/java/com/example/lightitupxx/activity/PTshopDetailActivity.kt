package com.example.lightitupxx.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lightitupxx.R
import kotlinx.android.synthetic.main.activity_ptshopdetail.*

class PTshopDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ptshopdetail)

        callptshop.setOnClickListener {
            var intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel: 02-976-4500")
            startActivity(intent)
        }
    }
}