package com.example.lightitupxx.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lightitupxx.R
import kotlinx.android.synthetic.main.activity_sharehousedetail.*

class SharehouseDetailActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sharehousedetail)

        callsharehouse.setOnClickListener {
            var intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel: 0507-1362-5608")
            startActivity(intent)
        }
    }
}