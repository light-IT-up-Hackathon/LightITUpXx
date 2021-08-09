package com.example.lightitupxx

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity

class MypageActivity:AppCompatActivity(){

    lateinit var layoutName:View
    lateinit var layoutScrap:View
    lateinit var layoutMyinfo:View
    lateinit var layoutNotice:View
    lateinit var layoutPolicy: View
    lateinit var layoutVersion:View
    lateinit var layoutCS:View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mypage)

        layoutName=findViewById(R.id.layout_name)
        layoutScrap=findViewById(R.id.layout_scrap)
        layoutNotice=findViewById(R.id.layout_notice)
        layoutCS=findViewById(R.id.layout_cs)
        layoutMyinfo=findViewById(R.id.layout_myinfo)
        layoutPolicy=findViewById(R.id.layout_policy)
        layoutVersion=findViewById(R.id.layout_version)

        scrapLayoutEvent()
        myinfoLayoutEvent()
        noticeLayoutEvent()
        csLayoutEvent()
        policyLayoutEvent()
        versionLayoutEvent()
    }

    private fun scrapLayoutEvent(){
        layoutScrap.setOnClickListener {
            (Toast.makeText(this, "scrap!!", Toast.LENGTH_SHORT)).show()
        }
    }
    private fun myinfoLayoutEvent(){
        layoutMyinfo.setOnClickListener {
            (Toast.makeText(this, "myInfo!!", Toast.LENGTH_SHORT)).show()
        }
    }
    private fun noticeLayoutEvent(){
        layoutNotice.setOnClickListener {
            (Toast.makeText(this, "notice!!", Toast.LENGTH_SHORT)).show()
        }
    }
    private fun csLayoutEvent(){
        layoutCS.setOnClickListener {
            (Toast.makeText(this, "CS!!", Toast.LENGTH_SHORT)).show()
        }
    }
    private fun policyLayoutEvent(){
        layoutPolicy.setOnClickListener {
            (Toast.makeText(this, "policy!!", Toast.LENGTH_SHORT)).show()
        }
    }
    private fun versionLayoutEvent(){
        layoutVersion.setOnClickListener {
            (Toast.makeText(this, "version!!", Toast.LENGTH_SHORT)).show()
        }
    }
}