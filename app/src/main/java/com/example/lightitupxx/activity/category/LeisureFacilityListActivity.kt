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
        leisure_wax.add(Facility_info(R.drawable.img_leisure_duie,"[두이에왁싱]","왁싱샵","평일 09시~20시","인천시 계양구"))
        leisure_wax.add(Facility_info(R.drawable.img_leisure_beauty,"[뷰티왁싱]","왁싱샵","평일 08시~22시","인천시 계양구"))
        leisure_wax.add(Facility_info(R.drawable.img_leisure_amelia,"[아멜리에왁싱]","왁싱샵","평일 10시~23시","경기도 고양시"))
        leisure_wax.add(Facility_info(R.drawable.img_leisure_sting,"[스팅턴왁싱]","왁싱샵","평일 10시~20시","서울시 구로구"))
        leisure_wax.add(Facility_info(R.drawable.img_leisure_comeling,"[코멜리왁싱]","왁싱샵","평일 08시~20시","서울시 노원구"))
        leisure_wax.add(Facility_info(R.drawable.img_leisure_vwaxing,"[여성전용V왁싱]","왁싱샵","평일 09시~20시","인천시 계양구"))

        leisure_tat.add(Facility_info(R.drawable.img_leisure_tob,"[토브타투]","터투샵","평일 09시~20시","인천시 계양구"))
        leisure_tat.add(Facility_info(R.drawable.img_leisure_baul,"[바울타투]","타투샵","평일 08시~20시","인천시 계양구"))
        leisure_tat.add(Facility_info(R.drawable.img_leisure_gabano,"[가바노타투]","타투샵","평일 09시~20시","경기도 고양시"))
        leisure_tat.add(Facility_info(R.drawable.img_leisure_hicari,"[히카리타투점]","타투샵","평일 10시~20시","서울시 구로구"))
        leisure_tat.add(Facility_info(R.drawable.img_leisure_with,"[위드타투]","타투샵","평일 08시~20시","서울시 노원구"))
        leisure_tat.add(Facility_info(R.drawable.img_leisure_leathre,"[레더타투]","타투샵","평일 09시~20시","인천시 계양구"))

        leisure_health.add(Facility_info(R.drawable.ptdetail,"[커브스월계클럽]","헬스장","평일 09시~20시","인천시 계양구"))
        leisure_health.add(Facility_info(R.drawable.img_leisure_cuves,"[커브스중계클럽]","헬스장","평일 08시~20시","인천시 계양구"))
        leisure_health.add(Facility_info(R.drawable.img_leisure_gongreung,"[커브스공릉클럽]","헬스장","평일 09시~20시","경기도 고양시"))
        leisure_health.add(Facility_info(R.drawable.img_leisure_jfit,"[Jfit여성전용PT샵]","헬스장","평일 10시~20시","서울시 구로구"))
        leisure_health.add(Facility_info(R.drawable.img_leisure_onebodygym,"[원바디짐]","헬스장","평일 08시~20시","서울시 노원구"))
        leisure_health.add(Facility_info(R.drawable.img_leisure_ladyfit,"[레이디핏피트니스]","헬스장","평일 09시~20시","인천시 계양구"))

        leisure_mass.add(Facility_info(R.drawable.img_leisure_queen,"[황후테라피]","마사지샵","평일 09시~20시","인천시 계양구"))
        leisure_mass.add(Facility_info(R.drawable.img_leisure_bundong,"[번동안마원]","마사지샵","평일 08시~20시","인천시 계양구"))
        leisure_mass.add(Facility_info(R.drawable.img_leisure_flow,"[폴로라에스테틱]","마사지샵","평일 09시~20시","경기도 고양시"))
        leisure_mass.add(Facility_info(R.drawable.img_leisure_bls9,"[블라썸테라피]","마사지샵","평일 10시~20시","서울시 구로구"))
        leisure_mass.add(Facility_info(R.drawable.img_leisure_wonly,"[여성전용케어샵]","마사지샵","평일 08시~20시","서울시 노원구"))
        leisure_mass.add(Facility_info(R.drawable.img_leisure_sgj,"[SGJ SPA]","마사지샵","평일 09시~20시","인천시 계양구"))
    }



}