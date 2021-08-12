package com.example.lightitupxx.activity.member

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.lightitupxx.R

class JoinActivity: AppCompatActivity() {

    lateinit var etv_id:EditText
    lateinit var etv_pwd:EditText
    lateinit var etv_birth:EditText
    lateinit var btn_join:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_join)

        etv_id=findViewById(R.id.etv_join_id)
        etv_pwd=findViewById(R.id.etv_join_pwd)
        etv_birth=findViewById(R.id.etv_join_birth)
        btn_join=findViewById(R.id.btn_join)

        btn_join.setOnClickListener {
            if(etv_birth.text.substring(6).equals("4")|| etv_birth.text.substring(6).equals("2")) {
                var intent = Intent(this, LoginActivity::class.java)
                user.id=etv_id.text.toString()
                user.pwd=etv_pwd.text.toString()
                startActivity(intent)
            }else{
                Toast.makeText(this, "엑스엑스는 \n여성만 가입 가능한 어플입니다.",Toast.LENGTH_SHORT).show()
            }
        }


    }

}