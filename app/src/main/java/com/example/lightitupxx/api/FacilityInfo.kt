package com.example.lightitupxx.api

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Facility_info (
    val image : Int,    //이미지
    val name : String,  //시설 이름
    val field : String, //종류
    val time : String,  //운영 시간
    val location :String,   //위치
    val latitude:Double?,   //위도
    val longtitude:Double?, //경도
    var phone:String="",    //전화번호
    var ping:String="", //상세 주소
    var way:String="없음",  //찾아가는 길
    var cost:String="없음",
    var option:String="없음",   //시설 옵션(ex. 주차, 인터넷)
    var hashtag:String="없음",  //해시 태그
    var comment:String="없음"   //그 외 업체 공지
    ) : Parcelable