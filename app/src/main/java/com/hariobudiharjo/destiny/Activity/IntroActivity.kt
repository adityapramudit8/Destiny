package com.hariobudiharjo.destiny.Activity

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.hariobudiharjo.destiny.R
import android.widget.TextView
import android.widget.LinearLayout
import android.support.v4.view.ViewPager
import android.widget.Button
import android.view.ViewGroup
import android.content.Context.LAYOUT_INFLATER_SERVICE
import android.graphics.Color
import android.support.v4.content.ContextCompat.getSystemService
import android.view.LayoutInflater
import android.support.v4.view.PagerAdapter
import android.view.View
import android.view.WindowManager
import android.os.Build
import android.text.Html
import com.hariobudiharjo.destiny.Activity.IntroActivity.MyViewPagerAdapter
import android.content.Intent
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.android.synthetic.main.slide1.*
import kotlinx.android.synthetic.main.slide2.*
import kotlinx.android.synthetic.main.slide3.*


class IntroActivity : AppCompatActivity() {
    lateinit var viewPager: ViewPager
    lateinit var myViewPagerAdapter: MyViewPagerAdapter
    lateinit var dotsLayout: LinearLayout
    lateinit var dots: Array<TextView>
    lateinit var layouts: IntArray
    lateinit var btnSkip: Button
    lateinit var btnNext: Button
//    private val prefManager: PrefManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        viewPager = findViewById<View>(R.id.view_pager) as ViewPager
        dotsLayout = findViewById<View>(R.id.layoutDots) as LinearLayout
        btnSkip = findViewById<View>(R.id.btn_skip) as Button
        btnNext = findViewById<View>(R.id.btn_next) as Button


        // layout xml slide 1 sampai 4
        // add few more layouts if you want
        layouts = intArrayOf(R.layout.slide1, R.layout.slide2, R.layout.slide3)

        // tombol dots (lingkaran kecil perpindahan slide)
        addBottomDots(0)

        // membuat transparan notifikasi
        changeStatusBarColor()

        myViewPagerAdapter = MyViewPagerAdapter()
        viewPager.adapter = myViewPagerAdapter
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener)

        btnSkip.setOnClickListener { launchHomeScreen() }

        btnNext.setOnClickListener {
            // mengecek page terakhir (slide 4)
            // jika activity home sudah tampil
            val current = getItem(+1)
            if (current < layouts.size) {
                // move to next screen
                viewPager.currentItem = current
            } else {
                launchHomeScreen()
            }
        }
    }

    private fun launchHomeScreen() {
//        prefManager.setFirstTimeLaunch(false)
        startActivity(Intent(this@IntroActivity, LoginActivity::class.java))
        finish()
    }

    private fun addBottomDots(currentPage: Int) {
        dots = arrayOf<TextView>()

        val colorsActive = resources.getIntArray(R.array.array_dot_active)
        val colorsInactive = resources.getIntArray(R.array.array_dot_inactive)

        dotsLayout!!.removeAllViews()
        for (i in 0 until dots!!.size) {
            dots!![i] = TextView(this)
            dots!![i].text = Html.fromHtml("&#8226;")
            dots!![i].setTextSize(35F)
            dots!![i].setTextColor(colorsInactive[currentPage])
            dotsLayout!!.addView(dots!![i])
        }

        if (dots.isNotEmpty())
            dots[currentPage].setTextColor(colorsActive[currentPage])
    }

    private fun getItem(i: Int): Int {
        return viewPager.currentItem + i
    }


    //  viewpager change listener
    var viewPagerPageChangeListener: ViewPager.OnPageChangeListener = object : ViewPager.OnPageChangeListener {

        override fun onPageSelected(position: Int) {
            addBottomDots(position)

            // mengubah button lanjut 'NEXT' / 'GOT IT'
            if (position == layouts!!.size - 1) {
                // last page. make button text to GOT IT
                btnNext?.setText(getString(R.string.start))
                btnSkip?.setVisibility(View.GONE)
            } else {
                // still pages are left
                btnNext?.setText(getString(R.string.next))
                btnSkip?.setVisibility(View.VISIBLE)
            }
        }

        override fun onPageScrolled(arg0: Int, arg1: Float, arg2: Int) {

        }

        override fun onPageScrollStateChanged(arg0: Int) {

        }
    }

    /**
     * Making notification bar transparent
     */
    private fun changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.TRANSPARENT
        }
    }

    /**
     * View pager adapter
     */
    inner class MyViewPagerAdapter : PagerAdapter() {
        private var layoutInflater: LayoutInflater? = null

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            layoutInflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

            val view = layoutInflater!!.inflate(layouts!![position], container, false)

//            if (position == 1) {
//                Glide.with(applicationContext).load(R.drawable.loading).asGif().crossFade().into(gambargif)
//            } else if (position==2) {
//                Glide.with(applicationContext).load(R.drawable.pencil).asGif().crossFade().into(gambargif)
//            } else {
//                Glide.with(applicationContext).load(R.drawable.light_lamp).asGif().crossFade().into(gambargif)
//            }
            container.addView(view)

            return view
        }

        override fun getCount(): Int {
            return layouts!!.size
        }

        override fun isViewFromObject(view: View, obj: Any): Boolean {
            return view === obj
        }


        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            val view = `object` as View
            container.removeView(view)
        }
    }
}
