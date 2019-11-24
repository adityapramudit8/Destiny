package com.hariobudiharjo.destiny.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.view.MenuItem
import com.hariobudiharjo.destiny.Fragment.ListMateriFragment
import com.hariobudiharjo.destiny.Fragment.ListSoalFragment
import com.hariobudiharjo.destiny.R

class LearningCoursesActivity : AppCompatActivity() {
    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learning_courses)
        getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true)

        viewPager = findViewById(R.id.viewpager)

        tabLayout = findViewById(R.id.tabs)
        tabLayout.setupWithViewPager(viewPager)
        setupViewPager(viewPager, "", "")
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        onBackPressed()
        return super.onOptionsItemSelected(item)
    }

    private fun setupViewPager(viewPager: ViewPager, overView: String, idTeam: String) {

//        val bundleOverView = Bundle()
//        bundleOverView.putString("overview", overView)
//
//        val bundleTeam = Bundle()
//        bundleTeam.putString("idteam", idTeam)

        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(ListMateriFragment(), "Materi")
        adapter.addFragment(ListSoalFragment(), "Soal")

//        val overviewFragment = OverviewDiscussionFragment()
//        val playerTeamFragment = CommentDiscussionFragment()

//        overviewFragment.arguments = bundleOverView
//        playerTeamFragment.arguments = bundleTeam

//        adapter.addFragment(overviewFragment, "Overview")
//        adapter.addFragment(playerTeamFragment, "Player")
        viewPager.adapter = adapter
    }

    internal inner class ViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager) {
        private val mFragmentList = arrayListOf<Fragment>()
        private val mFragmentTitleList = arrayListOf<String>()

        override fun getItem(position: Int): Fragment {
            return mFragmentList.get(position)
        }

        override fun getCount(): Int {
            return mFragmentList.size
        }

        fun addFragment(fragment: Fragment, title: String) {
            mFragmentList.add(fragment)
            mFragmentTitleList.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return mFragmentTitleList.get(position)
        }
    }
}
