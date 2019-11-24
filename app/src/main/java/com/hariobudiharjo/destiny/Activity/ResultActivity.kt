package com.hariobudiharjo.destiny.Activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.hariobudiharjo.destiny.R
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        this.title = "Congratulations"
        btn_done.setOnClickListener {
            val intent = Intent(it.context, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
