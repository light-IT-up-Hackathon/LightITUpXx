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
import com.example.lightitupxx.activity.detail.HospitalDetailActivity
import com.example.lightitupxx.adapter.FieldAdapter
import com.example.lightitupxx.adapter.HospitalAdapter
import com.example.lightitupxx.api.Facility_info
import com.example.lightitupxx.api.LocationItem
import com.example.lightitupxx.api.onItemClicked
import kotlinx.android.synthetic.main.activity_hospital_list.*
import java.util.*

class HospitalListActivity : AppCompatActivity(), onItemClicked {
    lateinit var backButton: View
    lateinit var fieldAdapter: FieldAdapter
    lateinit var facilityAdapter_san: HospitalAdapter
    lateinit var facilityAdapter_ne : HospitalAdapter
    lateinit var facilityAdapter_pi : HospitalAdapter
    lateinit var facilityAdapter_ebi : HospitalAdapter
    lateinit var facilityAdapter_jung : HospitalAdapter
    lateinit var facilityAdapter_chi : HospitalAdapter
    var num : Int = 0

    val field = ArrayList<LocationItem>()
    val hospital_san = ArrayList<Facility_info>()
    val hospitals_ne = ArrayList<Facility_info >()
    val hospitals_pi= ArrayList<Facility_info >()
    val hospitals_ebi = ArrayList<Facility_info >()
    val hospitals_jung = ArrayList<Facility_info >()
    val hospitals_chi = ArrayList<Facility_info >()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hospital_list)

        backButton = findViewById(R.id.img_hospitalPageBack)
        fieldAdapter = FieldAdapter(field)
        fieldlist_hospital.adapter = fieldAdapter
        fieldlist_hospital.setHasFixedSize(true) //어뎁터에 성능을 위한것
        //레이아웃 매니저를 이용해 어뎁터의 방향을 결정
        fieldlist_hospital.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        facilityAdapter_san = HospitalAdapter(hospital_san, this)
        facilityAdapter_ne = HospitalAdapter(hospitals_ne, this)
        facilityAdapter_pi = HospitalAdapter(hospitals_pi, this)
        facilityAdapter_ebi = HospitalAdapter(hospitals_ebi, this)
        facilityAdapter_jung = HospitalAdapter(hospitals_jung, this)
        facilityAdapter_chi = HospitalAdapter(hospitals_chi, this)

        recyclerGridView_hospital.adapter=facilityAdapter_san
        recyclerGridView_hospital.layoutManager= GridLayoutManager(applicationContext,2)

        backButton.setOnClickListener {
            onBackPressed()
        }

        fieldAdapter.setItemClickListener(object : FieldAdapter.OnItemClickListener {
            override fun onClick(v: View, position: Int) {

                Toast.makeText(v.context,
                    field[position].location, Toast.LENGTH_SHORT).show()

                fieldCheck(v, position)

                //검색
                val searchTerm=intent.getStringExtra("searchTerm")
            }
        })

        setField(fieldAdapter)
        setHospitalsList()

    }

    //병원 리스트 아이템 클릭시 실행되는 함수
    override fun onGridItemClick(idx: Int) {
        Log.d("key", "gsg")
        val intentGoToHospitalDetail = Intent(this, HospitalDetailActivity::class.java)
//        intentGoToHomeDetail.putExtra()
        startActivity(intentGoToHospitalDetail)
    }

    private fun fieldCheck(v: View, position: Int){
        if(field[position].location=="산부인과"){
            recyclerGridView_hospital.adapter=facilityAdapter_san
            recyclerGridView_hospital.layoutManager= GridLayoutManager(applicationContext,2)
        }
        else if(field[position].location=="내과"){
            recyclerGridView_hospital.adapter=facilityAdapter_ne
            recyclerGridView_hospital.layoutManager= GridLayoutManager(applicationContext,2)
        }
        else if(field[position].location=="피부과") {
            recyclerGridView_hospital.adapter=facilityAdapter_pi
            recyclerGridView_hospital.layoutManager= GridLayoutManager(applicationContext,2)
        }
        else if(field[position].location=="이비인후과"){
            recyclerGridView_hospital.adapter=facilityAdapter_ebi
            recyclerGridView_hospital.layoutManager= GridLayoutManager(applicationContext,2)
        }
        else if(field[position].location=="정형외과"){
            recyclerGridView_hospital.adapter=facilityAdapter_jung
            recyclerGridView_hospital.layoutManager= GridLayoutManager(applicationContext,2)
        }

    }

    private fun setField(fieldAdapter: FieldAdapter) {
        field.add(LocationItem("산부인과"))
        field.add(LocationItem("내과"))
        field.add(LocationItem("피부과"))
        field.add(LocationItem("이비인후과"))
        field.add(LocationItem("정형외과"))

    }

    private fun setHospitalsList(){
        hospital_san.add(Facility_info (R.drawable.hospital,"[남미현산부인과의원]","산부인과","평일 09시~19시","서울시 노원구", 37.65440231559509, 127.06164452531382))
        hospital_san.add(Facility_info (R.drawable.img_obhospital_park,"[박경숙산부인과]","산부인과","평일 09시~18시","서울시 노원구",37.65158089165931, 127.07594595381731))
        hospital_san.add(Facility_info (R.drawable.img_obhospital_ab,"[에비뉴여성의원]","산부인과","평일 10시~19시","서울시 노원구",37.655383719291, 127.06075391479209))
        hospital_san.add(Facility_info (R.drawable.img_ophospital_piona,"[피오나여성의원]","산부인과","평일 09시~21시","서울시 노원구",37.656879850593164, 127.0634833136795))
        hospital_san.add(Facility_info (R.drawable.img_obhospital_lee,"[이가영산부인과의원]","산부인과","평일 09~19시","서울시 노원구",37.65170617411463, 127.07741901367935))
        hospital_san.add(Facility_info (R.drawable.img_obhospital_gyu,"[박규희산부인과의원]","산부인과","평일 09시~17시","서울시 노원구",37.66523650214988, 127.05805302716998))

        hospitals_ne.add(Facility_info (R.drawable.img_imhospital_365,"[365열린의원]","내과","평일 09시~22시","서울시 노원구",37.641062120165884, 127.069936404806))
        hospitals_ne.add(Facility_info (R.drawable.img_imhospital_healthy,"[건강미소내과의원]","내과","평일 08시~19시","서울시 노원구",37.65438532734084, 127.06139256949666))
        hospitals_ne.add(Facility_info (R.drawable.img_imhospital_kim,"[김앤박내과의원]","내과","평일 09시~18시","서울시 노원구",37.65317938234547, 127.06121281182358))
        hospitals_ne.add(Facility_info (R.drawable.img_imhospital_micro,"[태능마이크로병원]","내과","평일 09시~18시","서울시 노원구",37.61825946405877, 127.07472256392828))
        hospitals_ne.add(Facility_info (R.drawable.img_imhospital_jaemin,"[제민통합내과정형외과의원]","내과","평일 09시~18시","서울시 노원구",37.656679351074736, 127.06198210018916))
        hospitals_ne.add(Facility_info (R.drawable.img_imhospital_samsung,"[삼성바른내과의원]","내과","평일 08시~18시","서울시 노원구",37.653929923983156, 127.07661157143266))

        hospitals_pi.add(Facility_info (R.drawable.img_pshospital_doc,"[닥터쁘띠의원]","피부과","평일 10시~20시","서울시 노원구",37.656480587473816, 127.05896138317323))
        hospitals_pi.add(Facility_info (R.drawable.img_pshospital_clean,"[클린업피부과의원]","피부과","평일 10시~20시","서울시 노원구",37.6680855126241, 127.05996424849391))
        hospitals_pi.add(Facility_info (R.drawable.img_pshospital_tox,"[톡스앤필의원]","피부과","평일 10시~20시","서울시 노원구",37.65640848314081, 127.06150553786279))
        hospitals_pi.add(Facility_info (R.drawable.img_pshostpital_cha,"[차앤박피부과의원]","피부과","평일 10시~20시","서울시 노원구",37.655503164220896, 127.06315983014166))
        hospitals_pi.add(Facility_info (R.drawable.img_shospital_abee,"[아비쥬의원]","피부과","평일 10시~20시","서울시 노원구",37.66245736271714, 127.0589201731129))
        hospitals_pi.add(Facility_info (R.drawable.img_pshospital_oaro,"[오아로피부과의원]","피부과","평일 10시~20시","서울시 노원구",37.65639382691609, 127.06447408353314))

        hospitals_ebi.add(Facility_info (R.drawable.img_enthospital_sky,"[새하늘이비인후과의원]","이비인후과","평일 09시~19시","서울시 노원구",37.67022440046417, 127.05725361587751))
        hospitals_ebi.add(Facility_info (R.drawable.img_enthospital_feel,"[기분조은이비인후과의원]","이비인후과","평일 08시~19시","서울시 노원구",37.65930345208498, 127.06246490489487))
        hospitals_ebi.add(Facility_info (R.drawable.img_enthospital_smart,"[스마트의원]","이비인후과","평일 10시~20시","서울시 노원구",37.65284382602109, 127.07068255414875))
        hospitals_ebi.add(Facility_info (R.drawable.img_enthospital_beandbe,"[비앤비이비인후과의원]","이비인후과","평일 09시~18시","서울시 노원구",37.65055505496304, 127.07712224251583))
        hospitals_ebi.add(Facility_info (R.drawable.img_enthospital_dasom,"[다솜이비인후과의원]","이비인후과","평일 09시~18시","서울시 노원구",37.680501559586304, 127.053933513036))
        hospitals_ebi.add(Facility_info (R.drawable.img_enthospital_cool,"[시원한이비인후과의원]","이비인후과","평일 09시~18시","서울시 노원구",37.6416291497995, 127.06809601111283))

        hospitals_jung.add(Facility_info (R.drawable.img_oshospital_mady,"[노원마디본의원]","정형외과","평일 09시~20시","서울시 노원구",37.65310901675621, 127.06132995600616))
        hospitals_jung.add(Facility_info (R.drawable.img_oshospital_bang,"[방병원]","정형외과","평일 08시~17시","서울시 노원구",37.61849265152965, 127.07507101367848))
        hospitals_jung.add(Facility_info (R.drawable.img_oshospital_strong,"[굳쎈정형외과의원]","정형외과","평일 09시~18시","서울시 노원구",37.67802514845685, 127.0549906001897))
        hospitals_jung.add(Facility_info (R.drawable.img_hospital_sangmo,"[성모오케이정형외과의원]","정형외과","평일 09시~18시","서울시 노원구",37.65599236951852, 127.06733332535853))
        hospitals_jung.add(Facility_info (R.drawable.img_oshospital_nobos,"[서울노보스병원]","정형외과","평일 09시~18시","서울시 노원구",37.65483586359399, 127.06199025414544))

    }




}
