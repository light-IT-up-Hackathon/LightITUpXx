package com.example.lightitupxx.activity.detail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.lightitupxx.R
import com.example.lightitupxx.api.Facility_info
import kotlinx.android.synthetic.main.activity_leisuredetail.*

class LeisureDetailActivity : AppCompatActivity() {

    lateinit var tv_name: TextView
    lateinit var tv_field: TextView
    lateinit var tv_location: TextView
    lateinit var tv_time: TextView
    lateinit var img_image: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leisuredetail)

        tv_name=findViewById(R.id.tv_name)
        tv_field=findViewById(R.id.tv_field)
        tv_location=findViewById(R.id.tv_location)
        tv_time=findViewById(R.id.tv_time)
        img_image=findViewById(R.id.img_image)

        if(intent.hasExtra("leisure")){
            var leisure=intent.getParcelableExtra<Facility_info>("leisure")
            tv_name.text=leisure?.name
            tv_field.text=leisure?.field
            tv_location.text=leisure?.location
            tv_time.text=leisure?.time

            img_image.setImageResource(leisure!!.image)
        }else{
            Toast.makeText(this,"존재하지 않는 내용입니다.", Toast.LENGTH_SHORT).show()
        }

        callptshop.setOnClickListener {
            var intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel: 02-976-4500")
            startActivity(intent)
        }
    }
}