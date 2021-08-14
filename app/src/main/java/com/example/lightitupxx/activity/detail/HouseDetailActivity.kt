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
import kotlinx.android.synthetic.main.activity_housedetail.*

class HouseDetailActivity : AppCompatActivity(){

    lateinit var tv_name: TextView
    lateinit var tv_field: TextView
    lateinit var tv_location: TextView
    lateinit var img_image: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_housedetail)

        tv_name=findViewById(R.id.tv_name)
        tv_field=findViewById(R.id.tv_field)
        tv_location=findViewById(R.id.tv_location)
        img_image=findViewById(R.id.img_image)

        if(intent.hasExtra("house")){
            var house=intent.getParcelableExtra<Facility_info>("house")
            tv_name.text=house?.name
            tv_field.text=house?.field
            tv_location.text=house?.location

            img_image.setImageResource(house!!.image)
        }else{
            Toast.makeText(this,"존재하지 않는 내용입니다.", Toast.LENGTH_SHORT).show()
        }

        callsharehouse.setOnClickListener {
            var intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel: 0507-1362-5608")
            startActivity(intent)
        }
    }
}