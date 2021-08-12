package com.example.lightitupxx.activity.member

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.lightitupxx.R
import org.jetbrains.anko.startActivity

class MypageActivity:AppCompatActivity(){

    lateinit var backButton:View
    lateinit var layoutName:View
    lateinit var layoutScrap:View
    lateinit var layoutMyinfo:View
    lateinit var layoutReserve:View
    lateinit var layoutCoupon: View
    lateinit var layoutVersion:View
    lateinit var layoutCS:View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mypage)

        layoutName=findViewById<ConstraintLayout>(R.id.layout_name)
        layoutScrap=findViewById<ConstraintLayout>(R.id.layout_scrap)
        layoutReserve=findViewById<ConstraintLayout>(R.id.layout_reserve)
        layoutCoupon=findViewById<ConstraintLayout>(R.id.layout_coupon)
        layoutMyinfo=findViewById<ConstraintLayout>(R.id.layout_myinfo)
        layoutCS=findViewById<ConstraintLayout>(R.id.layout_cs)
        layoutVersion=findViewById<ConstraintLayout>(R.id.layout_version)

        backButton = findViewById(R.id.img_myPageBack)

        backButton.setOnClickListener {
            onBackPressed()
        }

        scrapLayoutEvent()
        myinfoLayoutEvent()
        reserveLayoutEvent()
        csLayoutEvent()
        couponLayoutEvent()
        versionLayoutEvent()
    }

    private fun scrapLayoutEvent(){
        layoutScrap.setOnClickListener {
            startActivity<ScrapActivity>()
        }
    }
    private fun myinfoLayoutEvent(){
        layoutMyinfo.setOnClickListener {
            (Toast.makeText(this, "myInfo!!", Toast.LENGTH_SHORT)).show()
        }
    }
    private fun reserveLayoutEvent(){
        layoutReserve.setOnClickListener {
            startActivity<MypageReserveActivity>()
        }
    }
    private fun couponLayoutEvent(){
        layoutCoupon.setOnClickListener {
            startActivity<CouponActivity>()
        }
    }
    private fun csLayoutEvent(){
        layoutCS.setOnClickListener {
            startActivity<MypageCsActivity>()
        }
    }
    private fun versionLayoutEvent(){
        layoutVersion.setOnClickListener {
            startActivity<MypageVersionActivity>()
        }
    }
}