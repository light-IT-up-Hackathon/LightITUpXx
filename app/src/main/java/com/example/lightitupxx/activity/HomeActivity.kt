package com.example.lightitupxx.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.lightitupxx.R
import com.example.lightitupxx.activity.category.HouseFacilityListAcitvity
import com.example.lightitupxx.activity.category.HospitalListActivity
import com.example.lightitupxx.activity.category.LeisureFacilityListActivity
import com.example.lightitupxx.activity.community.CommuMainActivity
import com.example.lightitupxx.activity.member.MypageActivity
import org.jetbrains.anko.startActivity


class HomeActivity: AppCompatActivity() {
    //변수 미리 선언
    private lateinit var layoutHospital:View
    private lateinit var layoutleisure:View
    private lateinit var layouthelp:View
    private lateinit var layoutHome:View
    private lateinit var layoutMypage:View
    private lateinit var searchBox:EditText
    private lateinit var searchButton: Button

    //더미데이터
    val placeArray: Array<String> = arrayOf("이소아병원", "한유림병원", "안예린병원", "김성연병원")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //view 연결
        layoutHospital = findViewById<ConstraintLayout>(R.id.layout_Hospital)
        layoutleisure = findViewById<ConstraintLayout>(R.id.layout_Leisure)
        layoutHome = findViewById<ConstraintLayout>(R.id.layout_home)
        layouthelp=findViewById<ConstraintLayout>(R.id.layout_help)
        layoutMypage=findViewById(R.id.layout_mypage)
        searchBox = findViewById(R.id.searchBox)
        searchButton = findViewById(R.id.search_button)

        //함수 및 기능 구현
        hospitalLayoutEvent()
        leisureLayoutEvent()
        homeLayoutEvent()
        helpLayoutEvent()
        mypageLayoutEvent()
        searchButtonEvent()
    }

    //functions--> clickable layout including child
    private fun hospitalLayoutEvent(){
        layoutHospital.setOnClickListener {
            startActivity<HospitalListActivity>()
        }
    }
    private fun leisureLayoutEvent(){
        layoutleisure.setOnClickListener {
                startActivity<LeisureFacilityListActivity>()
        }
    }
    private fun homeLayoutEvent(){
        layoutHome.setOnClickListener {
                startActivity<HouseFacilityListAcitvity>()
        }
    }
    private fun helpLayoutEvent(){
        layouthelp.setOnClickListener {
            startActivity<CommuMainActivity>()
        }
    }

    private fun mypageLayoutEvent(){
        layoutMypage.setOnClickListener{
            startActivity<MypageActivity>()
        }
    }

    //검색
    private fun searchButtonEvent(){
        searchButton.setOnClickListener {
            val searchTerm=searchBox.text.toString()
            if(searchTerm.equals("남미현 산부인과")){
                var search_intent=Intent(this, HospitalListActivity::class.java)
                search_intent.putExtra("searchTerm", searchTerm)
                startActivity(search_intent)
            }else{
                Toast.makeText(this, "sival 없어", Toast.LENGTH_SHORT).show()
            }
        }
    }


}