package com.example.lightitupxx.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lightitupxx.Facility_info
import com.example.lightitupxx.R
import java.util.ArrayList

class HomeAdapter (val homeList : ArrayList<Facility_info>): RecyclerView.Adapter<HomeAdapter.CustomViewHolder1>() {
    //뷰홀더가 처음 생성될때
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder1 {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_griditem_home, parent, false)
        return CustomViewHolder1(view)
    }
    //재활용해주는 곳 및 값을 넣어주는 곳
    override fun onBindViewHolder(holder: CustomViewHolder1, position: Int) {
        holder.bindItems(homeList[position])
    }
    //리스트의 갯수를 적어준다
    override fun getItemCount(): Int {
        return homeList.size
    }
    //뷰홀더 클래스(음료수처럼 잡아주는 홀더)
    //이곳에서 파인드뷰아이디로 리스트 아이템에 있는 뷰들을 참조한다.
    inner class CustomViewHolder1(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(homes: Facility_info){
            val h_Image = itemView.findViewById<ImageView>(R.id.imageView_home)
            val h_name = itemView.findViewById<TextView>(R.id.home_name)
            val h_field = itemView.findViewById<TextView>(R.id.home_field)
            val h_time = itemView.findViewById<TextView>(R.id.home_time)
            val h_location = itemView.findViewById<TextView>(R.id.home_location)

            h_Image.setImageResource(homes.image)
            h_name.text = homes.name
            h_field.text = homes.field
            h_time.text = homes.time
            h_location.text = homes.location
        }
    }
}