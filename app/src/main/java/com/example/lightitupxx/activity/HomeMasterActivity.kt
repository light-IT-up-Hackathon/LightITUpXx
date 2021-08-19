package com.example.lightitupxx.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.example.lightitupxx.R

class HomeMasterActivity : AppCompatActivity() {

    lateinit var imageViewMaster : ImageView
    lateinit var edtTitle_master : EditText
    lateinit var edtTime_master : EditText
    lateinit var edtLocation_master : EditText
    lateinit var buttonMaster_Edit : Button
    lateinit var buttonMaster_Register : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_master)

        imageViewMaster = findViewById(R.id.imageView_master)
        edtTitle_master = findViewById(R.id.edtTitle_master)
        edtTime_master = findViewById(R.id.edtTime_master)
        edtLocation_master = findViewById(R.id.edtLocation_master)
        buttonMaster_Edit = findViewById(R.id.buttonMaster_Edit)
        buttonMaster_Register = findViewById(R.id.buttonMaster_Register)
    }
}