package com.hariobudiharjo.destiny.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.hariobudiharjo.destiny.R

class MateriActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_materi)
        getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true)
        this.title = "Materi"
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        onBackPressed()
        return super.onOptionsItemSelected(item)
    }
}
