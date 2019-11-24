package com.hariobudiharjo.destiny.Activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.MenuItem
import com.hariobudiharjo.destiny.R
import kotlinx.android.synthetic.main.activity_detail_courses.*

class DetailCoursesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_courses)

        getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true)

        this.title = "Detail Course"
        btn_learning.setOnClickListener {
            val intent = Intent(this, LearningCoursesActivity::class.java)
//            intent.putExtra("name", data.nama)
            ContextCompat.startActivity(it.context, intent, null)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        onBackPressed()
        return super.onOptionsItemSelected(item)
    }
}
