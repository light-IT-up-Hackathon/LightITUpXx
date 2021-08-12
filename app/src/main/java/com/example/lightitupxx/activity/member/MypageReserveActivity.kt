package com.example.lightitupxx.activity.member

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import com.example.lightitupxx.R
import com.example.lightitupxx.activity.detail.PTshopDetailActivity
import org.jetbrains.anko.startActivity

class MypageReserveActivity : AppCompatActivity() {

    lateinit var goptdetail : ImageButton
    lateinit var backButton: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_myreserve)

        goptdetail = findViewById(R.id.godetail)
        backButton = findViewById(R.id.img_myPageBack)

        goptdetail.setOnClickListener {
            startActivity<PTshopDetailActivity>()
        }

        backButton.setOnClickListener {
            onBackPressed()
        }
    }
}