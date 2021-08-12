package com.example.lightitupxx.activity.member

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.lightitupxx.R
import com.example.lightitupxx.activity.HomeActivity

class LoginActivity: AppCompatActivity() {

    lateinit var etv_login_id:EditText
    lateinit var etv_login_pwd:EditText
    lateinit var btn_login:Button
    lateinit var tv_joining:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etv_login_id=findViewById(R.id.etv_login_id)
        etv_login_pwd=findViewById(R.id.etv_login_pwd)
        btn_login=findViewById(R.id.btn_login)
        tv_joining=findViewById(R.id.tv_joining)

        tv_joining.setOnClickListener{
            startActivity(Intent(this, JoinActivity::class.java))
        }

        btn_login.setOnClickListener{
            if (intent.hasExtra("id")) {
                if (intent.getStringExtra("id").toString().contentEquals(etv_login_id.text)) {
                    if (intent.getStringExtra("pwd").toString().contentEquals(etv_login_pwd.text)) {
                        startActivity(Intent(this, HomeActivity::class.java))
                    } else {
                        Toast.makeText(this, "비밀번호가 틀립니다.", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this, "해당 아이디의 유저가 없습니다.", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "회원가입을 해주세요.", Toast.LENGTH_SHORT).show()
            }
        }


    }

}