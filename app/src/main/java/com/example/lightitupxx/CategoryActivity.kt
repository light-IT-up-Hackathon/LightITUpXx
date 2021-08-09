package com.example.lightitupxx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_category.*
import java.util.*

class CategoryActivity : AppCompatActivity() {

    lateinit var fieldAdapter: FieldAdapter
    lateinit var hospitalAdapter: HospitalAdapter
    lateinit var hospitalAdapter_ne : HospitalAdapter_ne
    lateinit var hospitalAdapter_pi : HospitalAdapter_pi
    lateinit var hospitalAdapter_ebi : HospitalAdapter_ebi
    lateinit var hospitalAdapter_jung : HospitalAdapter_jung
    lateinit var hospitalAdapter_chi : HospitalAdapter_chi
    val field = ArrayList<LocationItem>()
    val hospitals = ArrayList<Hospitals_san>()
    val hospitals_ne = ArrayList<Hospitals_ne>()
    val hospitals_pi= ArrayList<Hospitals_pi>()
    val hospitals_ebi = ArrayList<Hospitals_ebi>()
    val hospitals_jung = ArrayList<Hospitals_jung>()
    val hospitals_chi = ArrayList<Hospitals_chi>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        fieldAdapter = FieldAdapter(field)
        recyclerView_main2.adapter = fieldAdapter
        recyclerView_main2.setHasFixedSize(true)//어뎁터에 성능을 위한것
        //레이아웃매니저를 이용해 어뎁터의 방향을 결정
        recyclerView_main2.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        hospitalAdapter = HospitalAdapter(hospitals)
        hospitalAdapter_ne = HospitalAdapter_ne(hospitals_ne)
        hospitalAdapter_pi = HospitalAdapter_pi(hospitals_pi)
        hospitalAdapter_ebi = HospitalAdapter_ebi(hospitals_ebi)
        hospitalAdapter_jung = HospitalAdapter_jung(hospitals_jung)
        hospitalAdapter_chi = HospitalAdapter_chi(hospitals_chi)

        recyclerGridView_main2.adapter=hospitalAdapter
        recyclerGridView_main2.layoutManager= GridLayoutManager(applicationContext,2)

        fieldAdapter.setItemClickListener(object : FieldAdapter.OnItemClickListener {
            override fun onClick(v: View, position: Int) {

                Toast.makeText(v.context,
                    "${field[position].location}", Toast.LENGTH_SHORT).show()

                if(field[position].location=="산부인과"){
                    recyclerGridView_main2.adapter=hospitalAdapter
                    recyclerGridView_main2.layoutManager= GridLayoutManager(applicationContext,2)
                }
                else if(field[position].location=="내과"){
                    recyclerGridView_main2.adapter=hospitalAdapter_ne
                    recyclerGridView_main2.layoutManager= GridLayoutManager(applicationContext,2)
                }
                else if(field[position].location=="피부과") {
                    recyclerGridView_main2.adapter=hospitalAdapter_pi
                    recyclerGridView_main2.layoutManager= GridLayoutManager(applicationContext,2)
                }
                else if(field[position].location=="이비인후과"){
                    recyclerGridView_main2.adapter=hospitalAdapter_ebi
                    recyclerGridView_main2.layoutManager= GridLayoutManager(applicationContext,2)
                }
                else if(field[position].location=="정형외과"){
                    recyclerGridView_main2.adapter=hospitalAdapter_jung
                    recyclerGridView_main2.layoutManager= GridLayoutManager(applicationContext,2)
                }
                else if(field[position].location=="치과"){
                    recyclerGridView_main2.adapter=hospitalAdapter_chi
                    recyclerGridView_main2.layoutManager= GridLayoutManager(applicationContext,2)
                }

                //검색
                val searchTerm=intent.getStringExtra("searchTerm")
                if(field[position].location==searchTerm){
                    //우선은 걍 [김성연의원] 치면 산부인과 페이지 나오게 함
                    recyclerGridView_main2.adapter=hospitalAdapter
                    recyclerGridView_main2.layoutManager= GridLayoutManager(applicationContext,2)
                }

            }
        })

        field.add(LocationItem("산부인과"))
        field.add(LocationItem("내과"))
        field.add(LocationItem("피부과"))
        field.add(LocationItem("이비인후과"))
        field.add(LocationItem("정형외과"))
        field.add(LocationItem("치과"))

        hospitals.add(Hospitals_san(R.drawable.h_image0,"[엠엔비여성의원]","산부인과","평일 09시~20시","인천시 계양구"))
        hospitals.add(Hospitals_san(R.drawable.h_image0,"[김성연의원]","산부인과","평일 08시~20시","인천시 계양구"))
        hospitals.add(Hospitals_san(R.drawable.h_image0,"[이소아의원]","산부인과","평일 09시~20시","경기도 고양시"))
        hospitals.add(Hospitals_san(R.drawable.h_image0,"[안예린의원]","산부인과","평일 10시~20시","서울시 구로구"))
        hospitals.add(Hospitals_san(R.drawable.h_image0,"[한유림의원]","산부인과","평일 08시~20시","서울시 노원구"))
        hospitals.add(Hospitals_san(R.drawable.h_image0,"[복음병원]","산부인과","평일 09시~20시","인천시 계양구"))

        hospitals_ne.add(Hospitals_ne(R.drawable.h_image1,"[우리내과]","내과","평일 09시~20시","인천시 계양구"))
        hospitals_ne.add(Hospitals_ne(R.drawable.h_image1,"[서울내과]","내과","평일 08시~20시","인천시 계양구"))
        hospitals_ne.add(Hospitals_ne(R.drawable.h_image1,"[이소아내과]","내과","평일 09시~20시","경기도 고양시"))
        hospitals_ne.add(Hospitals_ne(R.drawable.h_image1,"[최고내과]","내과","평일 10시~20시","서울시 구로구"))
        hospitals_ne.add(Hospitals_ne(R.drawable.h_image1,"[세종내과]","내과","평일 08시~20시","서울시 노원구"))
        hospitals_ne.add(Hospitals_ne(R.drawable.h_image1,"[태릉내과]","내과","평일 09시~20시","인천시 계양구"))

        hospitals_pi.add(Hospitals_pi(R.drawable.h_image2,"[감자피부과]","피부과","평일 09시~20시","인천시 계양구"))
        hospitals_pi.add(Hospitals_pi(R.drawable.h_image2,"[김성연피부과]","피부과","평일 08시~20시","인천시 계양구"))
        hospitals_pi.add(Hospitals_pi(R.drawable.h_image2,"[이소아피부과]","피부과","평일 09시~20시","경기도 고양시"))
        hospitals_pi.add(Hospitals_pi(R.drawable.h_image2,"[안예린피부과]","피부과","평일 10시~20시","서울시 구로구"))
        hospitals_pi.add(Hospitals_pi(R.drawable.h_image2,"[한유림피부과]","피부과","평일 08시~20시","서울시 노원구"))
        hospitals_pi.add(Hospitals_pi(R.drawable.h_image2,"[해커톤피부과]","피부과","평일 09시~20시","인천시 계양구"))

        hospitals_ebi.add(Hospitals_ebi(R.drawable.h_image3,"[뀨이비인후과]","이비인후과","평일 09시~20시","인천시 계양구"))
        hospitals_ebi.add(Hospitals_ebi(R.drawable.h_image3,"[이비인후과]","이비인후과","평일 08시~20시","인천시 계양구"))
        hospitals_ebi.add(Hospitals_ebi(R.drawable.h_image3,"[가이비인후과]","이비인후과","평일 09시~20시","경기도 고양시"))
        hospitals_ebi.add(Hospitals_ebi(R.drawable.h_image3,"[나이비인후과]","이비인후과","평일 10시~20시","서울시 구로구"))
        hospitals_ebi.add(Hospitals_ebi(R.drawable.h_image3,"[다이비인후과]","이비인후과","평일 08시~20시","서울시 노원구"))
        hospitals_ebi.add(Hospitals_ebi(R.drawable.h_image3,"[라이비인후과]","이비인후과","평일 09시~20시","인천시 계양구"))

        hospitals_jung.add(Hospitals_jung(R.drawable.h_image4,"[서울정형외과]","정형외과","평일 09시~20시","인천시 계양구"))
        hospitals_jung.add(Hospitals_jung(R.drawable.h_image4,"[드림정형외과]","정형외과","평일 08시~20시","인천시 계양구"))
        hospitals_jung.add(Hospitals_jung(R.drawable.h_image4,"[비정형외과]","정형외과","평일 09시~20시","경기도 고양시"))
        hospitals_jung.add(Hospitals_jung(R.drawable.h_image4,"[반정형외과]","정형외과","평일 10시~20시","서울시 구로구"))
        hospitals_jung.add(Hospitals_jung(R.drawable.h_image4,"[개정형외과]","정형외과","평일 08시~20시","서울시 노원구"))

        hospitals_chi.add(Hospitals_chi(R.drawable.h_image5,"[서울치과]","치과","평일 09시~20시","인천시 계양구"))
        hospitals_chi.add(Hospitals_chi(R.drawable.h_image5,"[이상해치과]","치과","평일 08시~20시","인천시 계양구"))
        hospitals_chi.add(Hospitals_chi(R.drawable.h_image5,"[안아파치과]","치과","평일 09시~20시","경기도 고양시"))
        hospitals_chi.add(Hospitals_chi(R.drawable.h_image5,"[나몰라치과]","치과","평일 10시~20시","서울시 구로구"))
        hospitals_chi.add(Hospitals_chi(R.drawable.h_image5,"[같이봐치과]","치과","평일 08시~20시","서울시 노원구"))
    }
}

