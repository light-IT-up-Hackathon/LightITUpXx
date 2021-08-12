package com.example.lightitupxx.activity

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.lightitupxx.R
import com.example.lightitupxx.activity.category.HomeFacilityListAcitvity
import com.example.lightitupxx.activity.category.HospitalListActivity
import com.example.lightitupxx.activity.category.LeisureFacilityListActivity
import com.example.lightitupxx.activity.member.MypageActivity
import org.jetbrains.anko.startActivity


class HomeActivity: AppCompatActivity() {
    //변수 미리 선언
    private lateinit var layoutHospital:View
    private lateinit var layoutleisure:View
    private lateinit var layoutpublic:View
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
        layoutMypage=findViewById(R.id.layout_mypage)
        searchBox = findViewById(R.id.searchBox)
        searchButton = findViewById(R.id.search_button)

        //함수 및 기능 구현
        hospitalLayoutEvent()
        leisureLayoutEvent()
        homeLayoutEvent()
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
            layoutleisure.setOnClickListener {
                startActivity<LeisureFacilityListActivity>()
            }
        }

    }
    private fun homeLayoutEvent(){
        layoutHome.setOnClickListener {
            layoutHome.setOnClickListener {
                startActivity<HomeFacilityListAcitvity>()
            }
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
            if(searchTerm in placeArray){
                //예린이 detailActivity 연결시 변경
//                val intent=Intent(this, CategoryActivity::class.java)
//                intent.putExtra("searchTerm", searchTerm)
//                startActivity(intent)
                Toast.makeText(this, ""+searchTerm,Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "주변의 근거리 장소를 찾아 보아요!",Toast.LENGTH_SHORT).show()
            }

        }
    }


}