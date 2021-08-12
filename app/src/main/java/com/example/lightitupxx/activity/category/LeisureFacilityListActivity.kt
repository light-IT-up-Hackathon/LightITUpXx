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
import com.example.lightitupxx.adapter.LeisureFacilityAdapter
import com.example.lightitupxx.api.LocationItem
import kotlinx.android.synthetic.main.activity_hospital_list.*
import kotlinx.android.synthetic.main.activity_leisure_facility_list.*
import java.util.ArrayList

class LeisureFacilityListActivity : AppCompatActivity() {
    lateinit var backButton: View
    lateinit var fieldAdapter: FieldAdapter
    lateinit var facilityAdapter_wax: LeisureFacilityAdapter
    lateinit var facilityAdapter_tat : LeisureFacilityAdapter
    lateinit var facilityAdapter_health : LeisureFacilityAdapter
    lateinit var facilityAdapter_mass: LeisureFacilityAdapter

    val field = ArrayList<LocationItem>()
    val leisure_wax = ArrayList<Facility_info>()
    val leisure_tat = ArrayList<Facility_info>()
    val leisure_health= ArrayList<Facility_info>()
    val leisure_mass = ArrayList<Facility_info>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leisure_facility_list)

        backButton = findViewById(R.id.img_leisurePageBack)
        fieldAdapter = FieldAdapter(field)
        fieldlist_leisure.adapter = fieldAdapter
        fieldlist_leisure.setHasFixedSize(true) //어뎁터에 성능을 위한것
        //레이아웃 매니저를 이용해 어뎁터의 방향을 결정
        fieldlist_leisure.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        facilityAdapter_wax = LeisureFacilityAdapter (leisure_wax)
        facilityAdapter_tat= LeisureFacilityAdapter (leisure_tat)
        facilityAdapter_health = LeisureFacilityAdapter (leisure_health)
        facilityAdapter_mass = LeisureFacilityAdapter (leisure_mass)

        recyclerGridView_leisure.adapter=facilityAdapter_wax
        recyclerGridView_leisure.layoutManager= GridLayoutManager(applicationContext,2)

        fieldAdapter.setItemClickListener(object : FieldAdapter.OnItemClickListener {
            override fun onClick(v: View, position: Int) {

                Toast.makeText(v.context,
                    field[position].location, Toast.LENGTH_SHORT).show()
                fieldCheck(v, position)
            }
        })

        setField(fieldAdapter)
        setLeisureList()
        
    }
    private fun fieldCheck(v: View, position: Int){
        if(field[position].location=="왁싱샵"){
            recyclerGridView_leisure.adapter=facilityAdapter_wax
            recyclerGridView_leisure.layoutManager= GridLayoutManager(applicationContext,2)
        }
        else if(field[position].location=="타투샵"){
            recyclerGridView_leisure.adapter=facilityAdapter_tat
            recyclerGridView_leisure.layoutManager= GridLayoutManager(applicationContext,2)
        }
        else if(field[position].location=="헬스장") {
            recyclerGridView_leisure.adapter=facilityAdapter_health
            recyclerGridView_leisure.layoutManager= GridLayoutManager(applicationContext,2)
        }
        else if(field[position].location=="마사지샵"){
            recyclerGridView_leisure.adapter=facilityAdapter_mass
            recyclerGridView_leisure.layoutManager= GridLayoutManager(applicationContext,2)
        }
    }

    private fun setField(fieldAdapter: FieldAdapter) {
        field.add(LocationItem("왁싱샵"))
        field.add(LocationItem("타투샵"))
        field.add(LocationItem("헬스장"))
        field.add(LocationItem("마사지샵"))
    }

    private fun setLeisureList(){
        leisure_wax.add(Facility_info(R.drawable.h_image0,"[김성연잠지왁싱샵]","왁싱샵","평일 09시~20시","인천시 계양구"))
        leisure_wax.add(Facility_info(R.drawable.h_image0,"[한유림자지왁싱샵]","왁싱샵","평일 08시~20시","인천시 계양구"))
        leisure_wax.add(Facility_info(R.drawable.h_image0,"[자지왁싱샵]","왁싱샵","평일 09시~20시","경기도 고양시"))
        leisure_wax.add(Facility_info(R.drawable.h_image0,"[잠지왁싱샵]","왁싱샵","평일 10시~20시","서울시 구로구"))
        leisure_wax.add(Facility_info(R.drawable.h_image0,"[이소아잠지샵]","왁싱샵","평일 08시~20시","서울시 노원구"))
        leisure_wax.add(Facility_info(R.drawable.h_image0,"[김성연잠지샵]","왁싱샵","평일 09시~20시","인천시 계양구"))

        leisure_tat.add(Facility_info(R.drawable.h_image1,"[우리타투]","터투샵","평일 09시~20시","인천시 계양구"))
        leisure_tat.add(Facility_info(R.drawable.h_image1,"[서울타투]","타투샵","평일 08시~20시","인천시 계양구"))
        leisure_tat.add(Facility_info(R.drawable.h_image1,"[이소아타투]","타투샵","평일 09시~20시","경기도 고양시"))
        leisure_tat.add(Facility_info(R.drawable.h_image1,"[최고타투]","타투샵","평일 10시~20시","서울시 구로구"))
        leisure_tat.add(Facility_info(R.drawable.h_image1,"[세종타투]","타투샵","평일 08시~20시","서울시 노원구"))
        leisure_tat.add(Facility_info(R.drawable.h_image1,"[태릉타투]","타투샵","평일 09시~20시","인천시 계양구"))

        leisure_health.add(Facility_info(R.drawable.h_image2,"[감자피헬스장]","헬스장","평일 09시~20시","인천시 계양구"))
        leisure_health.add(Facility_info(R.drawable.h_image2,"[김성연헬스장]","헬스장","평일 08시~20시","인천시 계양구"))
        leisure_health.add(Facility_info(R.drawable.h_image2,"[이소아피헬스장]","헬스장","평일 09시~20시","경기도 고양시"))
        leisure_health.add(Facility_info(R.drawable.h_image2,"[안예린헬스장]","헬스장","평일 10시~20시","서울시 구로구"))
        leisure_health.add(Facility_info(R.drawable.h_image2,"[한유림헬스장]","헬스장","평일 08시~20시","서울시 노원구"))
        leisure_health.add(Facility_info(R.drawable.h_image2,"[해커톤헬스장]","헬스장","평일 09시~20시","인천시 계양구"))

        leisure_mass.add(Facility_info(R.drawable.h_image3,"[뀨이비마사지샵]","마사지샵","평일 09시~20시","인천시 계양구"))
        leisure_mass.add(Facility_info(R.drawable.h_image3,"[이비인마사지샵]","마사지샵","평일 08시~20시","인천시 계양구"))
        leisure_mass.add(Facility_info(R.drawable.h_image3,"[가이비마사지샵]","마사지샵","평일 09시~20시","경기도 고양시"))
        leisure_mass.add(Facility_info(R.drawable.h_image3,"[나이마사지샵]","마사지샵","평일 10시~20시","서울시 구로구"))
        leisure_mass.add(Facility_info(R.drawable.h_image3,"[다이비마사지샵]","마사지샵","평일 08시~20시","서울시 노원구"))
        leisure_mass.add(Facility_info(R.drawable.h_image3,"[라이비마사지샵]","마사지샵","평일 09시~20시","인천시 계양구"))
    }



}