package com.example.lightitupxx.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.lightitupxx.R
import com.example.lightitupxx.activity.member.user
import kotlinx.android.synthetic.main.activity_checkmyinfo.*
import org.w3c.dom.Text

class CheckmyinfoActivity : AppCompatActivity() {

    lateinit var backButton: View
    lateinit var name:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkmyinfo)

        backButton = findViewById(R.id.img_myPageBack)

        name=findViewById(R.id.name)    //이름 뜨는 부분 성연이가 합니당

        backButton.setOnClickListener {
            onBackPressed()
        }

    }
}