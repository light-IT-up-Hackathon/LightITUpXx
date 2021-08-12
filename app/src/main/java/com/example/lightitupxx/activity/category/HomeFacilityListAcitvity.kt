package com.example.lightitupxx.activity.category

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lightitupxx.Facility_info
import com.example.lightitupxx.R
import com.example.lightitupxx.adapter.FieldAdapter
import com.example.lightitupxx.adapter.HomeAdapter
import com.example.lightitupxx.api.LocationItem
import kotlinx.android.synthetic.main.activity_home_facility_list_acitvity.*
import kotlinx.android.synthetic.main.activity_hospital_list.*
import kotlinx.android.synthetic.main.activity_leisure_facility_list.*
import java.util.ArrayList

class HomeFacilityListAcitvity : AppCompatActivity() {
    lateinit var backButton: View
    lateinit var fieldAdapter: FieldAdapter
    lateinit var facilityAdapter_wal: HomeAdapter
    lateinit var facilityAdapter_jun : HomeAdapter
    lateinit var facilityAdapter_meme : HomeAdapter

    val field = ArrayList<LocationItem>()
    val leisure_wal = ArrayList<Facility_info >()
    val leisure_jun = ArrayList<Facility_info >()
    val leisure_meme= ArrayList<Facility_info >()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_facility_list_acitvity)

        backButton = findViewById(R.id.img_homePageBack)
        fieldAdapter = FieldAdapter(field)
        fieldlist_home.adapter = fieldAdapter
        fieldlist_home.setHasFixedSize(true) //어뎁터에 성능을 위한것
        //레이아웃 매니저를 이용해 어뎁터의 방향을 결정
        fieldlist_home.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        facilityAdapter_wal = HomeAdapter (leisure_wal)
        facilityAdapter_jun= HomeAdapter (leisure_jun)
        facilityAdapter_meme = HomeAdapter (leisure_meme)

        recyclerGridView_home.adapter=facilityAdapter_wal
        recyclerGridView_home.layoutManager= GridLayoutManager(applicationContext,2)


        fieldAdapter.setItemClickListener(object : FieldAdapter.OnItemClickListener {
            override fun onClick(v: View, position: Int) {

                Toast.makeText(v.context,
                    field[position].location, Toast.LENGTH_SHORT).show()
                fieldCheck(v, position)
            }
        })

        setField(fieldAdapter)
        setHospitalsList()
    }

    private fun fieldCheck(v: View, position: Int){
        if(field[position].location=="월세"){
            recyclerGridView_home.adapter=facilityAdapter_wal
            recyclerGridView_home.layoutManager= GridLayoutManager(applicationContext,2)
        }
        else if(field[position].location=="전세"){
            recyclerGridView_home.adapter=facilityAdapter_jun
            recyclerGridView_home.layoutManager= GridLayoutManager(applicationContext,2)
        }
        else if(field[position].location=="매매") {
            recyclerGridView_home.adapter=facilityAdapter_meme
            recyclerGridView_home.layoutManager= GridLayoutManager(applicationContext,2)
        }
    }

    private fun setField(fieldAdapter: FieldAdapter) {
        field.add(LocationItem("월세"))
        field.add(LocationItem("전세"))
        field.add(LocationItem("매매"))
    }

    private fun setHospitalsList(){
        leisure_wal.add(Facility_info (R.drawable.h_image0,"[김성연월세]","월세","평일 09시~20시","인천시 계양구"))
        leisure_wal.add(Facility_info (R.drawable.h_image0,"[한유림월세]","월세","평일 08시~20시","인천시 계양구"))
        leisure_wal.add(Facility_info (R.drawable.h_image0,"[자지원월세]","월세","평일 09시~20시","경기도 고양시"))
        leisure_wal.add(Facility_info (R.drawable.h_image0,"[잠지원월세]","월세","평일 10시~20시","서울시 구로구"))
        leisure_wal.add(Facility_info (R.drawable.h_image0,"[이소아월세]","월세","평일 08시~20시","서울시 노원구"))
        leisure_wal.add(Facility_info (R.drawable.h_image0,"[김성연월세]","월세","평일 09시~20시","인천시 계양구"))

        leisure_jun.add(Facility_info (R.drawable.h_image1,"[우리전세]","전세","평일 09시~20시","인천시 계양구"))
        leisure_jun.add(Facility_info (R.drawable.h_image1,"[서울전세]","전세","평일 08시~20시","인천시 계양구"))
        leisure_jun.add(Facility_info (R.drawable.h_image1,"[이소아전세]","전세","평일 09시~20시","경기도 고양시"))
        leisure_jun.add(Facility_info (R.drawable.h_image1,"[최고전세]","전세","평일 10시~20시","서울시 구로구"))
        leisure_jun.add(Facility_info (R.drawable.h_image1,"[세종전세]","전세","평일 08시~20시","서울시 노원구"))
        leisure_jun.add(Facility_info (R.drawable.h_image1,"[태릉전세]","전세","평일 09시~20시","인천시 계양구"))

        leisure_meme.add(Facility_info (R.drawable.h_image2,"[감자피매매]","매매","평일 09시~20시","인천시 계양구"))
        leisure_meme.add(Facility_info (R.drawable.h_image2,"[김성연매매]","매매","평일 08시~20시","인천시 계양구"))
        leisure_meme.add(Facility_info (R.drawable.h_image2,"[이소아피매매]","매매","평일 09시~20시","경기도 고양시"))
        leisure_meme.add(Facility_info (R.drawable.h_image2,"[안예린매매]","매매","평일 10시~20시","서울시 구로구"))
        leisure_meme.add(Facility_info (R.drawable.h_image2,"[한유림매매]","매매","평일 08시~20시","서울시 노원구"))
        leisure_meme.add(Facility_info (R.drawable.h_image2,"[해커톤매매]","매매","평일 09시~20시","인천시 계양구"))
    }
}