package com.example.lightitupxx.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.lightitupxx.Facility_info
import com.example.lightitupxx.R
import com.example.lightitupxx.activity.detail.HospitalDetailActivity
import java.util.*

class HospitalAdapter (val hospitalList : ArrayList<Facility_info>): RecyclerView.Adapter<HospitalAdapter.CustomViewHolder1>() {
    //뷰홀더가 처음 생성될때
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder1 {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_griditem_hospital, parent, false)
        return CustomViewHolder1(view)
    }
    //재활용해주는 곳 및 값을 넣어주는 곳
    override fun onBindViewHolder(holder: CustomViewHolder1, position: Int) {
        holder.bindItems(hospitalList[position])
        holder.itemView.setOnClickListener {
            itemClickListener.onClick(it, position)
        }
    }
    // (2) 리스너 인터페이스
    interface OnItemClickListener {
        fun onClick(v: View, position: Int)
    }
    // (3) 외부에서 클릭 시 이벤트 설정
    fun setItemClickListener(onItemClickListener: OnItemClickListener) {
        this.itemClickListener = onItemClickListener
    }
    // (4) setItemClickListener로 설정한 함수 실행
    private lateinit var itemClickListener : OnItemClickListener

    //리스트의 갯수를 적어준다
    override fun getItemCount(): Int {
        return hospitalList.size
    }

    //뷰홀더 클래스(음료수처럼 잡아주는 홀더)
    //이곳에서 파인드뷰아이디로 리스트 아이템에 있는 뷰들을 참조한다.
    inner class CustomViewHolder1(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(hospitals: Facility_info ){
            val h_Image = itemView.findViewById<ImageView>(R.id.imageView_hospital) //병원 종류
            val h_name = itemView.findViewById<TextView>(R.id.hospital_name)
            val h_field = itemView.findViewById<TextView>(R.id.hospital_field)
            val h_time = itemView.findViewById<TextView>(R.id.hospital_time)
            val h_location = itemView.findViewById<TextView>(R.id.hospital_location)

            h_Image.setImageResource(hospitals.image)
            h_name.text = hospitals.name
            h_field.text = hospitals.field
            h_time.text = hospitals.time
            h_location.text = hospitals.location
        }
    }
}
