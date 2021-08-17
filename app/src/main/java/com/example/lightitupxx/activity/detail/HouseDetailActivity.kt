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
import org.w3c.dom.Text

class HouseDetailActivity : AppCompatActivity(){

    lateinit var tv_name: TextView
    lateinit var tv_field: TextView
    lateinit var tv_location: TextView
    lateinit var img_image: ImageView
    lateinit var tv_phone:TextView
    lateinit var tv_ping:TextView
    lateinit var tv_way:TextView
    lateinit var tv_cost:TextView
    lateinit var tv_option:TextView
    lateinit var tv_hashtag:TextView
    lateinit var tv_comment:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_housedetail)

        tv_name=findViewById(R.id.tv_name)
        tv_field=findViewById(R.id.tv_field)
        tv_location=findViewById(R.id.tv_location)
        img_image=findViewById(R.id.img_image)

        tv_phone=findViewById(R.id.tv_phone)
        tv_ping=findViewById(R.id.tv_ping)
        tv_way=findViewById(R.id.tv_way)
        tv_cost=findViewById(R.id.tv_cost)
        tv_option=findViewById(R.id.tv_option)
        tv_hashtag=findViewById(R.id.tv_hashtag)
        tv_comment=findViewById(R.id.tv_comment)

        if(intent.hasExtra("house")){
            var house=intent.getParcelableExtra<Facility_info>("house")
            tv_name.text=house?.name
            tv_field.text=house?.field
            tv_location.text=house?.location
            img_image.setImageResource(house!!.image)

            tv_phone.text=house?.phone
            tv_ping.text=house?.ping
            tv_way.text=house?.way
            tv_cost.text=house?.cost
            tv_option.text=house?.option
            tv_hashtag.text=house?.hashtag
            tv_comment.text=house?.comment
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