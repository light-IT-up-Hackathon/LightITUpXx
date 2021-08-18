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
import com.example.lightitupxx.adapter.HomeAdapter
import com.example.lightitupxx.activity.HomeActivity
import com.example.lightitupxx.adapter.HospitalAdapter
import com.example.lightitupxx.api.Facility_info
import com.example.lightitupxx.api.LocationItem
import com.example.lightitupxx.api.onItemClicked
import kotlinx.android.synthetic.main.activity_hospital_list.*
import java.util.*
import com.example.lightitupxx.adapter.HospitalAdapter as HospitalAdapter1

class HospitalListActivity : AppCompatActivity(), onItemClicked {
    lateinit var backButton: View
    lateinit var fieldAdapter: FieldAdapter
    lateinit var facilityAdapter_san: HospitalAdapter1
    lateinit var facilityAdapter_ne : HospitalAdapter1
    lateinit var facilityAdapter_pi : HospitalAdapter1
    lateinit var facilityAdapter_ebi : HospitalAdapter1
    lateinit var facilityAdapter_jung : HospitalAdapter1
    lateinit var facilityAdapter_chi : HospitalAdapter1
    var num : Int = 0
    var field_idx:Int=0

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

        facilityAdapter_san = HospitalAdapter1(hospital_san, this)
        facilityAdapter_ne = HospitalAdapter1(hospitals_ne, this)
        facilityAdapter_pi = HospitalAdapter1(hospitals_pi, this)
        facilityAdapter_jung = HospitalAdapter1(hospitals_jung, this)
        facilityAdapter_chi = HospitalAdapter1(hospitals_chi, this)

        recyclerGridView_hospital.adapter=facilityAdapter_san
        recyclerGridView_hospital.layoutManager= GridLayoutManager(applicationContext,2)

        backButton.setOnClickListener { //뒤로가기
            onBackPressed()
        }

        fieldAdapter.setItemClickListener(object : FieldAdapter.OnItemClickListener {
            override fun onClick(v: View, position: Int) {
                field_idx=position

                Toast.makeText(v.context,
                    field[position].location, Toast.LENGTH_SHORT).show()

                fieldCheck(v, position)
            }
        })


        setField(fieldAdapter)
        setHospitalsList()

    }

    //병원 리스트 아이템 클릭시 실행되는 함수
    override fun onGridItemClick(idx: Int) {
        Log.d("key", "gsg")
        val intentGoToHospitalDetail = Intent(this, HospitalDetailActivity::class.java)
        if(field_idx==0){
            intentGoToHospitalDetail.putExtra("hospital",hospital_san[idx])
        }else if(field_idx==1){
            intentGoToHospitalDetail.putExtra("hospital",hospitals_ne[idx])
        }else if(field_idx==2){
            intentGoToHospitalDetail.putExtra("hospital",hospitals_pi[idx])
        } else if(field_idx==4){
            intentGoToHospitalDetail.putExtra("hospital",hospitals_jung[idx])
        }else{
            Toast.makeText(this,"해당 필드가 존재하지 않습니다.",Toast.LENGTH_SHORT).show()
        }

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
        else if(field[position].location=="정형외과"){
            recyclerGridView_hospital.adapter=facilityAdapter_jung
            recyclerGridView_hospital.layoutManager= GridLayoutManager(applicationContext,2)
        }

    }

    private fun setField(fieldAdapter: FieldAdapter) {
        field.add(LocationItem("산부인과"))
        field.add(LocationItem("내과"))
        field.add(LocationItem("피부과"))
        field.add(LocationItem("정형외과"))
    }

    private fun setHospitalsList(){
        //산부인과
        hospital_san.add(Facility_info (R.drawable.hospital,"[남미현산부인과의원]","산부인과","평일 09시~19시","서울시 노원구", 37.65440231559509, 127.06164452531382,
        "02-938-5557","서울 노원구 노해로 482","노원역 5번 출구에서 순복음교회쪽으로 올라오시면 우리은행 건물 7층에 위치하고 있습니다","","주차, 예약, 무선 인터넷, 남/녀 화장실 구분",
            "노원역 롯데백화점 건너편에 위치한 남미현 산부인과는 여러가지 진료와 편안한 상담으로 진료를 하고 있습니다.\n" +
                    "\n" +
                    "-------------------------------------------- 진료과목 -------------------------------------------------\n" +
                    "산전검사, 초음파검사, 부인암검진, 고주파치료, 갱년기상담 및 치료, 부인성형수술, 불임증상담 및 배란유도 등"))
        hospital_san.add(Facility_info (R.drawable.img_obhospital_park,"[박경숙산부인과]","산부인과","평일 09시~18시","서울시 노원구",37.65158089165931, 127.07594595381731,
            "02-933-9230","서울 노원구 한글비석로 253 세신프라자빌딩 2층","","","주차, 예약, 무선 인터넷, 남/녀 화장실 구분","공휴일은 휴무입니다."))
        hospital_san.add(Facility_info (R.drawable.img_obhospital_ab,"[에비뉴여성의원]","산부인과","평일 10시~19시","서울시 노원구",37.655383719291, 127.06075391479209,
        "02-936-0400", "서울 노원구 노해로 480","7호선 노원역 5번 출구 또는 4호선 2번 출구로 나와 롯데백화점 건너편, 버스정류장은 상계주공5단지","","주차, 예약, 무선 인터넷, 남/녀 화장실 구분",
            "#소음순수술\n" +
                    "#이쁜이수술\n" +
                    "#질성형수술\n" +
                    "#여성성형\n" +
                    "#노원여의사산부인과\n",
            "에비뉴는 대로, 가로수길의 의미입니다. 여성회음성형, 산부인과 진료, 미용의학 등 여성의학을 시술함에 있어, 항상 원칙을 어긋나지 않는 큰 길을 걷고자 하는 마음과 함께, 고객에게 가로수길과 같은 편안함을 " +
                    "드리는 것을 최우선의 가치로 삼고 있습니다."))
        hospital_san.add(Facility_info (R.drawable.img_ophospital_piona,"[피오나여성의원]","산부인과","평일 09시~21시","서울시 노원구",37.656879850593164, 127.0634833136795,
        "02-951-7111","서울 노원구 상계로 77 다나플라자","노원역 10번 출구로 나오셔서 9번 출구 방향으로 5m 걸어 오시면 대로변 건물 (카페베네) 3층에 위치하고 있습니다.","","주차, 예약, 무선 인터넷, 남/녀 화장실 구분",
        "키워드\n" +
                "#노원산부인과\n" +
                "#미혼여성검진\n" +
                "#산부인과검사\n" +
                "#유방암검사\n" +
                "#노원여의사산부인과",
            "건강한 아름다움을 추구하는 피오나 여성의원은 진정한 아름아음을 만들어 드립니다.\n" +
                    "피오나는 여성의 피부 클리닉 및 산부인과를 세분화 하여 미용 전문병원으로써 전문지식과 풍부한 경험을 기반으로 한 여성의 아름다움에 갈망과 욕구를 충족 시켜 최고의 가치실현을 목표로 노력하고 있습니다.\n" +
                    "여의사 ,여성질성형, 산부인과 , ppc보톡스,탈모,비만 ,여성성형 등 모든 미적 시술이 가능합니다.\n" +
                    "유혹의 대명사가 피오나가 될수 있도록 여러분을 기다리겠습니다" ))
        hospital_san.add(Facility_info (R.drawable.img_obhospital_lee,"[이가영산부인과의원]","산부인과","평일 09~19시","서울시 노원구",37.65170617411463, 127.07741901367935,
        "02-952-0997","서울 노원구 한글비석로 270 스카이빌딩 4층","노원구 중계동 은행사거리 S-oil 주유소 옆","","주차",
            "#노원산부인과\n" +
                    "#노원여성암검진\n" +
                    "#노원비만치료\n" +
                    "#노원경부암백신\n" +
                    "#중계동산부인과",
        "여의사진료, 일반부인과, 여성암검진, 경부암백신, 여성성형, 콘딜로마, 비만치료"))
        hospital_san.add(Facility_info (R.drawable.img_obhospital_gyu,"[박규희산부인과의원]","산부인과","평일 09시~17시","서울시 노원구",37.66523650214988, 127.05805302716998,
        "02-932-0700","서울 노원구 동일로 1530","","","주차, 예약, 무선 인터넷, 남/녀 화장실 구분"))



        //내과
        hospitals_ne.add(Facility_info (R.drawable.img_imhospital_365,"[365열린의원]","내과","평일 09시~22시","서울시 노원구",37.641062120165884, 127.069936404806,
        "02-976-3658","서울 노원구 한글비석로 77 한성여객(주)"))
        hospitals_ne.add(Facility_info (R.drawable.img_imhospital_healthy,"[건강미소내과의원]","내과","평일 08시~19시","서울시 노원구",37.65438532734084, 127.06139256949666,
        "02-931-5513","서울 노원구 노해로 480 조광빌딩","7호선 노원역 5번출구에서 20m거리-신한은행 옆 5층.","","주차, 예약, 남/녀 화장실 구분",
        "#대장내시경\n" +
                "#위내시경\n" +
                "#내과\n" +
                "#수면내시경\n" +
                "#건강검진",
        "안녕하세요. 건강미소내과의원 입니다.\n" +
                "저희병원은 의료보험관리공단지정 국가암검진기관으로 5 대암검진을 시행하고 있습니다.\n" +
                "또한 한번수면으로 위,대장내시경, 용종 절제술까지 모두 가능하며 방문하시면 영원한 주치의가 되어드립니다."))
        hospitals_ne.add(Facility_info (R.drawable.img_imhospital_kim,"[김앤박내과의원]","내과","평일 09시~18시","서울시 노원구",37.65317938234547, 127.06121281182358,
        "02-930-7601","서울 노원구 동일로 1392","지하철 7호선 5번출구 도보1분 상계주공 6단지 버스정류장 앞 다이소 빌딩 3층에 위치하고 있습니다.","","주차, 예약, 남/녀 화장실 구분",
        "#수면대장내시경\n" +
                "#수면위내시경",
        "반갑습니다 김앤박 내과입니다.\n" +
                "\n" +
                "본원은 다년간 대학병원 검진센터에서 근무한 내시경 전문의로써의 경험을 바탕으로 한, 내과 전문의 2인이 진료하는 내시경 전문 병원입니다.\n" +
                "\n" +
                "대학병원급에서 사용하는 최신 기종인 올림푸스 CV 260 내시경을 사용하고 있으며, 철저한 1대1 내시경 세척과 소독으로 환자분들이 안심하고 검사 받으실수 있도록 하고 있습니다.\n" +
                "\n" +
                "북카페같은 편안한 분위기의 진료 대기공간을 조성하여 기다리시는 시간이 지루하거나 불편하지 않게 최선의 노력을 다하고 있으며, 여의사 전문의의 친절하고 세심한 진료로 지역주민들의 건강과 안녕을 책임지고자 합니다.\n" +
                "\n" +
                "언제나 여러분의 곁에 친근하게 다가서는 병원이 되도록 노력하겠습니다.\n" +
                "\n" +
                "감사합니다."))
        hospitals_ne.add(Facility_info (R.drawable.img_imhospital_micro,"[태능마이크로병원]","내과","평일 09시~18시","서울시 노원구",37.61825946405877, 127.07472256392828,
        "02-970-0900","서울 노원구 동일로 987","지하철 6, 7호선 태릉입구역 2번 출구 앞, 공릉초등학교 정문 앞.","","주차, 예약, 무선 인터넷, 남/녀 화장실 구분",
        "",
        "수지접합, 미세혈관 및 신경복원술, 만성골반통, 목, 허리, 무릎, 어깨통증, 당뇨족 치료 및 내과 관련 질환을 전문적으로 치료하는 병원."))
        hospitals_ne.add(Facility_info (R.drawable.img_imhospital_jaemin,"[제민통합내과정형외과의원]","내과","평일 09시~18시","서울시 노원구",37.656679351074736, 127.06198210018916,
        "02-936-6390","서울 노원구 상계로 63-7 청우빌딩 4층","4호선 노원역 9번 출구 - 아이맥스안경원 골목 우회전 - 할리스커피 건물 4층( 주공아파트 7단지 702동 앞)","","주차, 예약, 무선 인터넷, 남/녀 화장실 구분",
        "토요일 진료 운영 : 물리치료 / 내시경 가능,\n" +
                "건강검진, 위 / 대장내시경, 초음파 검사 예약가능\n" +
                "NAVER 지식인 전문의학상담의\n" +
                "내과 : 당뇨병, 고혈압, 갑상선, 골다공증, 비만, 소아당뇨병, 소아비만, 당뇨병발궤양, 대사증후군 등\n" +
                "정형외과, : 물리치료, 골절, 척추교정, 외상, 성장판, 통증클리닉, 교통사고, 등\n" +
                "건강검진센터 : 건강보험공단검진, 종합건강검진, 학생검진, 채용검진, 종합혈액검사( EDC / 혈액조기검진)",
        ))
        hospitals_ne.add(Facility_info (R.drawable.img_imhospital_samsung,"[삼성바른내과의원]","내과","평일 08시~18시","서울시 노원구",37.653929923983156, 127.07661157143266,
        "02-3392-2475","서울 노원구 한글비석로 270","중계동 은행사거리 S-oil 주요소 옆","","주차",
        "#노원내시경검사\n" +
                "#노원초음파검사\n" +
                "#노원5대암검진\n" +
                "#노원종합검진센터\n" +
                "#노원구내과",
            "내시경검사, 초음파검사, 5대암검진, 종합검진센터, 여성검진센터, 직장인검진, 고혈압/당뇨/성인병, 비만/통증/골다공증, 수액 치료 전문 병원"
        ))



        //피부과
        hospitals_pi.add(Facility_info (R.drawable.img_pshospital_doc,"[닥터쁘띠의원]","피부과","평일 10시~20시","서울시 노원구",37.656480587473816, 127.05896138317323,
        "02-3392-4285","서울 노원구 동일로 1396 중원빌딩 3층","노원역5번 출구에서75m","","",
        "#노원피부과\n" +
                "#노원필러\n" +
                "#노원보톡스\n" +
                "#노원리프팅\n" +
                "#노원윤곽주사",
        "예뻐지는 시간 beauty O'clock\n" +
                "닥터쁘띠클리닉 입니다.\n" +
                "닥터쁘띠 네트워크는\n" +
                "보톡스,필러,리프팅,안티에이징,피부미용,비만관리,제모클리닉을 중점으로 진료하고 있는\n" +
                "토탈 뷰티클리닉 입니다.\n" +
                "1. 숙련된 의사에게 합리적인 비용으로, 보톡스, 필러 시술을 받을수 있습니다.\n" +
                "2. 전 제품 정품 정량제도, 눈 앞에서 정품 개봉을 시행합니다.\n" +
                "3. 다양하고 많은 시술 케이스를 바탕으로 뛰어난 실력을 가지고 있는 원장님들이\n" +
                "고객님께 가장 어울리는 아름다움을 선사합니다.\n" +
                "4. 자체 세미나를 진행하여 다양한 사례연구 및 최신 노하우를 서로 공유하고 발전시켜 고객님께\n" +
                "만족스러운 결과를 제공하기 위해 끊임없이 노력하고 있습니다.\n" +
                "5. 전문적이고 정성을 다한 상담을 통해 고객 감동 서비스를 제공하고 있습니다."))
        hospitals_pi.add(Facility_info (R.drawable.img_pshospital_clean,"[클린업피부과의원]","피부과","평일 10시~20시","서울시 노원구",37.6680855126241, 127.05996424849391,
        "0507-1434-8289","서울 노원구 노해로 480 조광빌딩 8층","지하철 7호선 노원역 5번출구로 나오신 후 올리브영 건물 8층","","주차, 예약, 무선 인터넷, 남/녀 화장실 구분",
        "키워드\n" +
                "#노원피부과\n" +
                "#피부과전문의\n" +
                "#골드PTT여드름치료\n" +
                "#엑셀V플러스\n" +
                "#써마지FLX",
        "CU클린업피부과는 2001년 영등포점을 시작으로 해 국내 10개 지점으로 구성된 피부과전문의 네트워크 피부과입니다. 보건복지부 선정 외국인 환자 유치 의료기관으로서 국내 뿐만 아니라 해외 각지의 환자들에게도 한국의 우수한 의료 서비스를 알리고 있습니다."))
        hospitals_pi.add(Facility_info (R.drawable.img_pshospital_tox,"[톡스앤필의원]","피부과","평일 10시~20시","서울시 노원구",37.65640848314081, 127.06150553786279,
        "02-933-7585","서울 노원구 노해로 488 근호빌딩","4호선 이용 시 노원역 2번 출구, 7호선 이용 시 노원역 5번 출구로 나오시는 것이 오시기 편리합니다.", "","주차, 예약, 남/녀 화장실 구분",
        "#노원피부과\n" +
                "#노원톡스앤필\n" +
                "#필러\n" +
                "#보톡스\n" +
                "#슈링크",
        "빠르고 편리한 예약을 위해 전화 또는 홈페이지 예약 부탁드립니다 :)"))
        hospitals_pi.add(Facility_info (R.drawable.img_pshostpital_cha,"[차앤박피부과의원]","피부과","평일 10시~20시","서울시 노원구",37.655503164220896, 127.06315983014166,
        "0507-1331-0571","서울 노원구 노해로 495","노원역 4호선 2번 출구 또는 7호선 4번 출구로 나와 도보로 200m 이내 거리에 위치하고 있습니다.","","주차, 예약, 무선 인터넷, 남/녀 화장실 구분",
        "#여드름흉터_SDRT\n" +
                "#지방이식리포필러\n" +
                "#기미레이저토닝\n" +
                "#레이저눈밑지방재배치\n" +
                "#주름울쎄라리프팅",
                "CNP차앤박피부과는 1996년 본원을 시작으로 현재 25개 지점을 가진 대규모 피부과 네트워크로 5년 연속 (2007년~2011년) 퍼스트브랜드 대상과 2008, 2009년 2년 연속 대한민국 글로벌 의료마케팅 대상을 수상한 고객분들께 인정받는 명품 피부과 브랜드입니다. 차앤박피부과는 보다 나은 의료 서비스를 제공하기 위해 끊임없이 연구합니다.\n"))
        hospitals_pi.add(Facility_info (R.drawable.img_shospital_abee,"[아비쥬의원]","피부과","평일 10시~20시","서울시 노원구",37.66245736271714, 127.0589201731129,
        "1544-0377","서울 노원구 동일로 1417 삼양빌딩 2,5층","","","주차, 예약, 무선 인터넷, 남/녀 화장실 구분, 제로페이, 홈페이지",
        "#노원피부과\n" +
                "#노원브라질리언\n" +
                "#노원보톡스\n" +
                "#노원필러\n" +
                "#노원슈링크",
        "예약문의: 카카오톡 @아비쥬노원\n" +
                "01. 친절한 상담을 통한 감동 서비스 제공\n" +
                "02. 저렴하고 정직한 가격으로 아름다움을 선사\n" +
                "03. 프리미엄 장비 보유 및 업그레이드 유지\n" +
                "04. 정품/정량을 원칙으로 하는 아비쥬의원\n"))
        hospitals_pi.add(Facility_info (R.drawable.img_pshospital_oaro,"[오아로피부과의원]","피부과","평일 10시~20시","서울시 노원구",37.65639382691609, 127.06447408353314,
        "02-930-1500","서울 노원구 노해로 507","지하철 4호선 노원역 1번출구에서 100m 직진 7호선 노원역 4번출구에서 150m 직진 하시면 됩니다.","","단체석, 주차, 예약, 무선 인터넷, 남/녀 화장실 구분, 장애인 편의시설, 지역화폐(지류형), 지역화폐(카드형), 지역화폐(모바일형), 제로페이",
        "키워드\n" +
                "#노원역피부과\n" +
                "#여드름\n" +
                "#기미\n" +
                "#리프팅\n" +
                "#주름",
        "주차 시설 완비. 건물내 지하주차장 완비!\n" +
                "서울대 출신 피부과전문의 3인 진료!\n" +
                "340평 강북 대표급 규모. 만족도 1등급!\n" +
                "여드름, 여드름 흉터, 피부.성형.비만.\n" +
                "개인 맞춤진료 & 최고 시설의 관리\n" +
                "보건산업대상 수상 병원"))



        /*이비인후과
        hospitals_ebi.add(Facility_info (R.drawable.img_enthospital_sky,"[새하늘이비인후과의원]","이비인후과","평일 09시~19시","서울시 노원구",37.67022440046417, 127.05725361587751,
        "02-951-9518","서울 노원구 동일로 1548 세일빌딩 3층","7호선 마들역 1번 출구로 나와 의정부 방면 5m 거리에 위치해 있습니다.","","",
        "새하늘이비인후과에서는 두 분의 전문의 선생님으로부터 최신의 장비를 이용하여, 코콜이, 비염, 축농증 등의 수술과, 후두내시경, 소아 이비인후과 클리닉, 이명, 난청 클리닉 및 보청기 제작 등 다양한 의료혜택을 누릴 수 있습니다."))
        hospitals_ebi.add(Facility_info (R.drawable.img_enthospital_feel,"[기분조은이비인후과의원]","이비인후과","평일 08시~19시","서울시 노원구",37.65930345208498, 127.06246490489487,
        "0507-1422-2025","서울 노원구 한글비석로 359 딩","상계역1번 출구에서431m","남/녀 화장실 구분","",
        "가장 최근 진료,휴진 일정!은 아래 페이지에서 확 인하실수 있습니다. http://happyent.modoo.at/ h ttps://happyent.modoo.at/ "))
        hospitals_ebi.add(Facility_info (R.drawable.img_enthospital_smart,"[스마트의원]","이비인후과","평일 10시~20시","서울시 노원구",37.65284382602109, 127.07068255414875,
        "02-952-8866","서울 노원구 노원로 330 롯데마트","롯데마트 중계점 3층 입니다.","","주차, 남/녀 화장실 구분",
        "#야간진료\n" +
                "#공휴일진료\n" +
                "#비만\n" +
                "#예방접종\n" +
                "#소아진료",
        "토.일요일, 공휴일에도 야간까지 진료를 하는 스마트의원 입니다. 평일 20시까지 토. 일요일, 공휴일 18시까지 진료(2,4 주 일요일 휴무, 일요일 기준 매주 화요일 휴무)하여 환자분들께 편의를 제공합니다."))
        hospitals_ebi.add(Facility_info (R.drawable.img_enthospital_beandbe,"[비앤비이비인후과의원]","이비인후과","평일 09시~18시","서울시 노원구",37.65055505496304, 127.07712224251583,
        "02-931-7582","서울 노원구 한글비석로 254 대명프라자","중계동 은행사거리(국민, 우리은행 사거리) 우리은행 건너편 김밥천국, 시루가 있는 건물인 대명프라자 3층에 위치.","","","",
        "차를 이용하실 경우 건물 뒷편 지하주차장(엘리베이터)를 이용해주세요.(무료)"))
        hospitals_ebi.add(Facility_info (R.drawable.img_enthospital_dasom,"[다솜이비인후과의원]","이비인후과","평일 09시~18시","서울시 노원구",37.680501559586304, 127.053933513036,
        "02-937-5111","서울 노원구 동일로 1677 제성빌딩","7호선 수락산역 5번 출구로 나오셔서 바로 앞에 있는 파리바게트 건물 6층","","","",
        "항상 환자의 건강을 먼저 생각하는 다솜 이비인후과."))
        hospitals_ebi.add(Facility_info (R.drawable.img_enthospital_cool,"[시원한이비인후과의원]","이비인후과","평일 09시~18시","서울시 노원구",37.6416291497995, 127.06809601111283,
        "02-971-3631","서울 노원구 동일로204가길 34 씨앤미","7호선 하계역 1번 출구, 2001 아울렛과 홈플러스 사이 씨앤미 빌딩.","","주차, 예약",
        "#비염\n" +
                "#보청기\n" +
                "#축농증\n" +
                "#중이염",
        "시원한 이비인후과는 대학병원에서 얻은 풍부한 진료와 치료경험을 바탕으로 환자분들께서 편안하고 빠르게 진료와 수술을 받으실 수 있도록 최선의 노력을 다하고 있습니다. "))


         */


        //정형외과
        hospitals_jung.add(Facility_info (R.drawable.img_oshospital_mady,"[노원마디본의원]","정형외과","평일 09시~20시","서울시 노원구",37.65310901675621, 127.06132995600616,
        "0507-1485-8278","서울 노원구 동일로 1392 한일빌딩 다이소 4층","노원마디본의원은 노원역 5번출구 50m앞 다이소 건물 4층에위치한 정형외과입니다.","","주차, 예약, 무선 인터넷, 남/녀 화장실 구분, 장애인 편의시설, 지역화폐(카드형), 제로페이",
        "#노원역정형외과\n" +
                "#노원역야간진료\n" +
                "#노원역도수치료\n" +
                "#노원역체외충격파\n" +
                "#노원역물리치료",
        "척추관절클리닉, 도수치료클리닉, 체외충격파클리닉 비수술적시술클리닉, 자동차사고클리닉, 스포츠손상클리닉, 영상정밀주사, 연부조직클리닉, 노인성질환클리닉, 골프클리닉\n" +
                "\n" +
                "노원마디본의원은 정확한 진단과 꼭 필요한 치료로 지역주민의 건강을 책임지는 친절한 병원이 되겠습니다."))
        hospitals_jung.add(Facility_info (R.drawable.img_oshospital_bang,"[방병원]","정형외과","평일 08시~17시","서울시 노원구",37.61849265152965, 127.07507101367848,
        "1577-4447","서울 노원구 동일로 989","6,7호선 태릉입구역 2번출구 바로 앞","","주차, 발렛파킹, 예약, 무선 인터넷, 남/녀 화장실 구분",
        "#조직재생신경성형술\n" +
                "#인공관절\n" +
                "#디스크내시경수술\n" +
                "#퇴행성관절염\n" +
                "#카티스템",
               "저희 병원은 관절, 척추, 뇌신경, 내과, 건강검진 을 하는 병원으로써\n" +
               "개원 15년 이상 된 지역에서 사랑받는 병원입니다." ))
        hospitals_jung.add(Facility_info (R.drawable.img_oshospital_strong,"[굳쎈정형외과의원]","정형외과","평일 09시~18시","서울시 노원구",37.67802514845685, 127.0549906001897,
        "02-2038-4987","서울 노원구 동일로 1673 상계빌딩","","","","토요일 14시까지 진료"))
        hospitals_jung.add(Facility_info (R.drawable.img_hospital_sangmo,"[성모오케이정형외과의원]","정형외과","평일 09시~18시","서울시 노원구",37.65599236951852, 127.06733332535853,
        "031-523-3450","경기 구리시 갈매중앙로 91 한덕프라자","성모오케이정형외과는 갈매중앙로 한덕프라자 4층에 위치해 있습니다.","","주차",
        "#갈매정형외과\n" +
                "#갈매도수치료\n" +
                "#구리시정형외과\n" +
                "#갈매물리치료\n" +
                "#갈매재활의학과",
        "진료과목:\n" +
                "1. 어깨관절: 오십견, 석회성건염, 회전근개파열, 충돌증후군\n" +
                "2. 무릎관절: 퇴행성관절염, 반월상연골판손상, 인대 손상\n" +
                "3. 척추 통증: 일자목, 거북목, 디스크, 척추관협착증, 측만증\n" +
                "4. 그 외 근골격계 질환: 스포츠 손상, 골절 클리닉 등"))
        hospitals_jung.add(Facility_info (R.drawable.img_oshospital_nobos,"[서울노보스병원]","정형외과","평일 09시~18시","서울시 노원구",37.65483586359399, 127.06199025414544,
        "0507-1300-3250","서울 도봉구 도봉로 720","도봉구 방학역 1번 출구와 연결.", "","주차, 남/녀 화장실 구분",
                "#병원\n" +
                "#도봉구병원",
        "항상 가족과 같은 마음으로 정성과 최선을 다하겠습니다."))

    }




}
