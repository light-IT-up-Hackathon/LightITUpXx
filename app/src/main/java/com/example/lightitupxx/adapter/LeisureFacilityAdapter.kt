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

class LeisureFacilityAdapter (val leisureList : ArrayList<Facility_info>):
    RecyclerView.Adapter<LeisureFacilityAdapter.CustomViewHolder1>() {
    //뷰홀더가 처음 생성될 때
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder1 {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_griditem_leisure, parent, false)
        return CustomViewHolder1(view)
    }
    //재활용해주는 곳 및 값을 넣어주는 곳
    override fun onBindViewHolder(holder: CustomViewHolder1, position: Int) {
        holder.bindItems(leisureList[position])
    }
    //리스트의 갯수를 적어준다
    override fun getItemCount(): Int {
        return leisureList.size
    }
    //뷰홀더 클래스(음료수처럼 잡아주는 홀더)
    //이곳에서 파인드뷰아이디로 리스트 아이템에 있는 뷰들을 참조한다.
    inner class CustomViewHolder1(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(leisures:Facility_info ){
            val l_Image = itemView.findViewById<ImageView>(R.id.imageView_leisure)
            val l_name = itemView.findViewById<TextView>(R.id.leisure_name)
            val l_field = itemView.findViewById<TextView>(R.id.leisure_field)
            val l_time = itemView.findViewById<TextView>(R.id.leisure_time)
            val l_location = itemView.findViewById<TextView>(R.id.leisure_location)

            l_Image.setImageResource(leisures.image)
            l_name.text = leisures.name
            l_field.text = leisures.field
            l_time.text = leisures.time
            l_location.text = leisures.location
        }
    }
}