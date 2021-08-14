package com.example.lightitupxx.activity.category

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lightitupxx.R
import com.example.lightitupxx.activity.detail.SharehouseDetailActivity
import com.example.lightitupxx.adapter.FieldAdapter
import com.example.lightitupxx.adapter.HomeAdapter
import com.example.lightitupxx.api.Facility_info
import com.example.lightitupxx.api.LocationItem
import com.example.lightitupxx.api.onItemClicked
import kotlinx.android.synthetic.main.activity_home_facility_list_acitvity.*
import java.util.ArrayList

class HomeFacilityListAcitvity : AppCompatActivity(), onItemClicked {
    lateinit var backButton: View
    lateinit var fieldAdapter: FieldAdapter
    lateinit var facilityAdapter_wal: HomeAdapter
    lateinit var facilityAdapter_jun : HomeAdapter
    lateinit var facilityAdapter_meme : HomeAdapter

    val field = ArrayList<LocationItem>()
    val leisure_wal = ArrayList<Facility_info>()
    val leisure_jun = ArrayList<Facility_info >()
    val leisure_meme= ArrayList<Facility_info >()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_facility_list_acitvity)

        backButton = findViewById(R.id.img_homePageBack)
        fieldAdapter = FieldAdapter(field)
        fieldlist_home.adapter = fieldAdapter
        fieldlist_home.setHasFixedSize(true) //어뎁터에 성능을 위한 것
        //레이아웃 매니저를 이용해 어뎁터의 방향을 결정
        fieldlist_home.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        facilityAdapter_wal = HomeAdapter (leisure_wal, this)
        facilityAdapter_jun= HomeAdapter (leisure_jun, this)
        facilityAdapter_meme = HomeAdapter (leisure_meme, this)

        recyclerGridView_home.adapter=facilityAdapter_wal
        recyclerGridView_home.layoutManager= GridLayoutManager(applicationContext,2)

        backButton.setOnClickListener {
            onBackPressed()
        }

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

    //주거시설 리스트 아이템 클릭시 실행되는 함수
    override fun onGridItemClick(idx: Int) {
        Log.d("key", "gsg")
        val intentGoToHomeDetail = Intent(this, SharehouseDetailActivity::class.java)
//        intentGoToHomeDetail.putExtra()
        startActivity(intentGoToHomeDetail)
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
        leisure_wal.add(Facility_info (R.drawable.img_home_sanggyejugong7,"[상계주공7단지]","월세","701동 1211호","서울시 노원구", 37.65904745825612, 127.0604076840165))
        leisure_wal.add(Facility_info (R.drawable.img_home_sodambill,"[소담빌]","월세","B동 302호","서울시 노원구", 37.6197880321966, 127.07789245517912))
        leisure_wal.add(Facility_info (R.drawable.img_home_chungsole,"[상계청솔아파트]","월세","125동 121호","서울시 노원구", 37.62337044501715, 127.08652253983522))
        leisure_wal.add(Facility_info (R.drawable.img_home_daeho,"[대호]","월세","805동 709호","서울시 노원구", 37.65998124324081, 127.07330162634443))
        leisure_wal.add(Facility_info (R.drawable.img_home_yumguang,"[염광]","월세","103동 705호","서울시 노원구",37.65689225680142, 127.07361639750847))
        leisure_wal.add(Facility_info (R.drawable.img_home_junggyegugong4,"[중계주공4단지]","월세","405동 306호","서울시 노원구", 37.65536512596464, 127.07704025518042))

        leisure_jun.add(Facility_info (R.drawable.img_home_shindonga,"[신동아]","전세","106동 904호","서울시 노원구", 37.66757191874165, 127.06754948968242))
        leisure_jun.add(Facility_info (R.drawable.img_home_sanggyejugong9,"[상계주공9단지]","전세","912동 505호","서울시 노원구", 37.66296229077105, 127.06025586867261))
        leisure_jun.add(Facility_info (R.drawable.img_home_sanggyejugong7,"[상계주공7단지]","전세","707동 202호","서울시 노원구",37.65904745825612, 127.0604076840165))
        leisure_jun.add(Facility_info (R.drawable.img_home_hanshin,"[한신]","전세","107동 905호","서울시 노원구", 37.66667123671229, 127.06722110893563))
        leisure_jun.add(Facility_info (R.drawable.img_home_byuksan,"[벽산]","전세","201동 514호","서울시 노원구", 37.661744612944695, 127.07235918462773))
        leisure_jun.add(Facility_info (R.drawable.img_home_anusbill,"[중계경남아너스빌]","전세","704동 404호","서울시 노원구", 37.66216395208811, 127.07683398149281))

        leisure_meme.add(Facility_info (R.drawable.img_home_joogong,"[상계주공7단지]","매매","107동 1103호","서울시 노원구", 37.65904745825612, 127.0604076840165))
        leisure_meme.add(Facility_info (R.drawable.img_home_ganyoung,"[건영2차]","매매","102동 705호","서울시 노원구", 37.662192432105265, 127.07676099349958))
        leisure_meme.add(Facility_info (R.drawable.img_home_sung,"[성원]","매매","403동 104호","서울시 노원구", 37.66165701263498, 127.07519454607062))
        leisure_meme.add(Facility_info (R.drawable.img_home_green,"[중계그린]","매매","113동 104호","서울시 노원구", 37.641805160445664, 127.06358972819615))
        leisure_meme.add(Facility_info (R.drawable.img_home_hansin,"[한신3차]","매매","301동 209호","서울시 노원구", 37.666460017554265, 127.06735947819688))
        leisure_meme.add(Facility_info (R.drawable.img_home_sunglim,"[성림]","매매","901동 506호","서울시 노원구", 37.67321959228559, 127.08066319750056))
    }

}