package com.hariobudiharjo.destiny.Activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.hariobudiharjo.destiny.R
import kotlinx.android.synthetic.main.activity_soal.*

class SoalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_soal)
        getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true)
        this.title = "Soal"
        btn_next.setOnClickListener {
            val intent = Intent(it.context, ResultActivity::class.java)
            startActivity(intent)
        }
    }
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        onBackPressed()
        return super.onOptionsItemSelected(item)
    }
}
