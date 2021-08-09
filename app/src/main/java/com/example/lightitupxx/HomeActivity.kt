package com.example.lightitupxx

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout


class HomeActivity: AppCompatActivity() {
    //변수 미리 선언
    private lateinit var layoutHospital:View
    private lateinit var layoutleisure:View
    private lateinit var layoutpublic:View
    private lateinit var layoutHome:View
    private lateinit var searchBox:EditText
    private lateinit var searchButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //코드 작성

        //view 연결
        layoutHospital = findViewById<ConstraintLayout>(R.id.layout_Hostpital)
        layoutleisure = findViewById<ConstraintLayout>(R.id.layout_Leisure)
        layoutpublic = findViewById<ConstraintLayout>(R.id.layout_public)
        layoutHome = findViewById<ConstraintLayout>(R.id.layout_home)
        searchBox = findViewById(R.id.searchBox)
        searchButton = findViewById(R.id.search_button)

        //함수 및 기능 구현
        hospitalLayoutEvent()
        leisureLayoutEvent()
        publicFacilityLayoutEvent()
        homeLayoutEvent()
        searchButtonEvent()


    }


    //functions--> clickable layout including child
    private fun hospitalLayoutEvent(){
        layoutHospital.setOnClickListener {
            val myToast = Toast.makeText(this, "layouthospital", Toast.LENGTH_SHORT)
            myToast.show()
        }
    }
    private fun leisureLayoutEvent(){
        layoutleisure.setOnClickListener {
            val myToast = Toast.makeText(this, "layoutleisure", Toast.LENGTH_SHORT)
            myToast.show()
        }

    }
    private fun publicFacilityLayoutEvent(){
        layoutpublic.setOnClickListener {
            val myToast = Toast.makeText(this, "layoutpublic", Toast.LENGTH_SHORT)
            myToast.show()
        }
    }
    private fun homeLayoutEvent(){
        layoutHome.setOnClickListener {
            val myToast = Toast.makeText(this, "layoutHome", Toast.LENGTH_SHORT)
            myToast.show()
        }
    }

    //functions
    private fun searchButtonEvent(){
        searchButton.setOnClickListener {
            val myToast = Toast.makeText(this,"searchButton clicked!!", Toast.LENGTH_SHORT)
            myToast.show()
        }
    }


}