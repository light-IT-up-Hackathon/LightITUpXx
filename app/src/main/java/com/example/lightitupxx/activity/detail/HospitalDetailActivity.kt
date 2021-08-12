package com.example.lightitupxx.activity.detail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lightitupxx.R
import kotlinx.android.synthetic.main.activity_hospitaldetail.*

class HospitalDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hospitaldetail)

        callhospitalBtn.setOnClickListener {
            var intent = Intent(Intent.ACTION_DIAL)
            intent.data= Uri.parse("tel: 02-938-5557")
            startActivity(intent)
        }

    }
}