package com.hariobudiharjo.destiny.Activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.hariobudiharjo.destiny.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val thread = object : Thread() {
            override fun run() {
                try {
                    Thread.sleep(2000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                } finally {
                    startActivity(Intent(this@SplashActivity, IntroActivity::class.java))
//                    startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                    finish()
                }
            }
        }
        thread.start()
    }
}
