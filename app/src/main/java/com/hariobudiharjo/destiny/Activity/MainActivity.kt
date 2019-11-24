package com.hariobudiharjo.destiny.Activity

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import com.hariobudiharjo.destiny.Fragment.*
import com.hariobudiharjo.destiny.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var currentFragment: Fragment

    lateinit var ft: FragmentTransaction
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                currentFragment = HomeFragment()
                ft = supportFragmentManager.beginTransaction()
                ft.replace(R.id.fl_main, currentFragment)
                ft.commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_discussion -> {
                currentFragment = DiscussionFragment()
                ft = supportFragmentManager.beginTransaction()
                ft.replace(R.id.fl_main, currentFragment)
                ft.commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_study -> {
                currentFragment = FunStudyFragment()
                ft = supportFragmentManager.beginTransaction()
                ft.replace(R.id.fl_main, currentFragment)
                ft.commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_news -> {
                currentFragment = NewsFragment()
                ft = supportFragmentManager.beginTransaction()
                ft.replace(R.id.fl_main, currentFragment)
                ft.commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_profile -> {
                currentFragment = ProfileFragment()
                ft = supportFragmentManager.beginTransaction()
                ft.replace(R.id.fl_main, currentFragment)
                ft.commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        currentFragment = HomeFragment()

        ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.fl_main, currentFragment)
        ft.commit()

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
