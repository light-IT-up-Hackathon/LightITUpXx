package com.example.lightitupxx

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class HospitalAdapter (val hospitalList : ArrayList<Hospitals_san>): RecyclerView.Adapter<HospitalAdapter.CustomViewHolder1>() {
    //뷰홀더가 처음 생성될때
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HospitalAdapter.CustomViewHolder1 {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_griditem, parent, false)
        return CustomViewHolder1(view)
    }
    //재활용해주는 곳 및 값을 넣어주는 곳
    override fun onBindViewHolder(holder: HospitalAdapter.CustomViewHolder1, position: Int) {
        holder.bindItems(hospitalList[position])
    }
    //리스트의 갯수를 적어준다
    override fun getItemCount(): Int {
        return hospitalList.size
    }
    //뷰홀더 클래스(음료수처럼 잡아주는 홀더)
    //이곳에서 파인드뷰아이디로 리스트 아이템에 있는 뷰들을 참조한다.
    inner class CustomViewHolder1(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(hospitals: Hospitals_san){
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

class HospitalAdapter_ne (val hospitalList : ArrayList<Hospitals_ne>): RecyclerView.Adapter<HospitalAdapter_ne.CustomViewHolder_ne>() {
    //뷰홀더가 처음 생성될때
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HospitalAdapter_ne.CustomViewHolder_ne {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_griditem, parent, false)
        return CustomViewHolder_ne(view)
    }
    //재활용해주는 곳 및 값을 넣어주는 곳
    override fun onBindViewHolder(holder: HospitalAdapter_ne.CustomViewHolder_ne, position: Int) {
        holder.bindItems(hospitalList[position])
    }
    //리스트의 갯수를 적어준다
    override fun getItemCount(): Int {
        return hospitalList.size
    }
    //뷰홀더 클래스(음료수처럼 잡아주는 홀더)
    //이곳에서 파인드뷰아이디로 리스트 아이템에 있는 뷰들을 참조한다.
    inner class CustomViewHolder_ne(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(hospitals: Hospitals_ne){
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

class HospitalAdapter_pi (val hospitalList : ArrayList<Hospitals_pi>): RecyclerView.Adapter<HospitalAdapter_pi.CustomViewHolder_pi>() {
    //뷰홀더가 처음 생성될때
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HospitalAdapter_pi.CustomViewHolder_pi {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_griditem, parent, false)
        return CustomViewHolder_pi(view)
    }
    //재활용해주는 곳 및 값을 넣어주는 곳
    override fun onBindViewHolder(holder: HospitalAdapter_pi.CustomViewHolder_pi, position: Int) {
        holder.bindItems(hospitalList[position])
    }
    //리스트의 갯수를 적어준다
    override fun getItemCount(): Int {
        return hospitalList.size
    }
    //뷰홀더 클래스(음료수처럼 잡아주는 홀더)
    //이곳에서 파인드뷰아이디로 리스트 아이템에 있는 뷰들을 참조한다.
    inner class CustomViewHolder_pi(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(hospitals: Hospitals_pi){
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
class HospitalAdapter_ebi (val hospitalList : ArrayList<Hospitals_ebi>): RecyclerView.Adapter<HospitalAdapter_ebi.CustomViewHolder_ebi>() {
    //뷰홀더가 처음 생성될때
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HospitalAdapter_ebi.CustomViewHolder_ebi {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_griditem, parent, false)
        return CustomViewHolder_ebi(view)
    }
    //재활용해주는 곳 및 값을 넣어주는 곳
    override fun onBindViewHolder(holder: HospitalAdapter_ebi.CustomViewHolder_ebi, position: Int) {
        holder.bindItems(hospitalList[position])
    }
    //리스트의 갯수를 적어준다
    override fun getItemCount(): Int {
        return hospitalList.size
    }
    //뷰홀더 클래스(음료수처럼 잡아주는 홀더)
    //이곳에서 파인드뷰아이디로 리스트 아이템에 있는 뷰들을 참조한다.
    inner class CustomViewHolder_ebi(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(hospitals: Hospitals_ebi){
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
class HospitalAdapter_jung (val hospitalList : ArrayList<Hospitals_jung>): RecyclerView.Adapter<HospitalAdapter_jung.CustomViewHolder_jung>() {
    //뷰홀더가 처음 생성될때
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HospitalAdapter_jung.CustomViewHolder_jung {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_griditem, parent, false)
        return CustomViewHolder_jung(view)
    }
    //재활용해주는 곳 및 값을 넣어주는 곳
    override fun onBindViewHolder(holder: HospitalAdapter_jung.CustomViewHolder_jung, position: Int) {
        holder.bindItems(hospitalList[position])
    }
    //리스트의 갯수를 적어준다
    override fun getItemCount(): Int {
        return hospitalList.size
    }
    //뷰홀더 클래스(음료수처럼 잡아주는 홀더)
    //이곳에서 파인드뷰아이디로 리스트 아이템에 있는 뷰들을 참조한다.
    inner class CustomViewHolder_jung(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(hospitals: Hospitals_jung){
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
class HospitalAdapter_chi (val hospitalList : ArrayList<Hospitals_chi>): RecyclerView.Adapter<HospitalAdapter_chi.CustomViewHolder_chi>() {
    //뷰홀더가 처음 생성될때
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HospitalAdapter_chi.CustomViewHolder_chi {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_griditem, parent, false)
        return CustomViewHolder_chi(view)
    }
    //재활용해주는 곳 및 값을 넣어주는 곳
    override fun onBindViewHolder(holder: HospitalAdapter_chi.CustomViewHolder_chi, position: Int) {
        holder.bindItems(hospitalList[position])
    }
    //리스트의 갯수를 적어준다
    override fun getItemCount(): Int {
        return hospitalList.size
    }
    //뷰홀더 클래스(음료수처럼 잡아주는 홀더)
    //이곳에서 파인드뷰아이디로 리스트 아이템에 있는 뷰들을 참조한다.
    inner class CustomViewHolder_chi(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(hospitals: Hospitals_chi){
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