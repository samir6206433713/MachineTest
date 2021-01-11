package com.tutorial.machinetest.activity

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.tutorial.machinetest.R
import com.tutorial.machinetest.activity.ScreenSlidePagerActivity
import com.tutorial.machinetest.fragment.ScreenSlidePageFragment
import java.util.*

class ScreenSlidePagerActivity : FragmentActivity() {
    var floatingbutton: FloatingActionButton? = null
    var pagecount = 0
    var currentPage = 0
    var timer: Timer? = null
    val DELAY_MS: Long = 500 //delay in milliseconds before task is to be executed
    val PERIOD_MS: Long = 3000

    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private var mPager: ViewPager? = null

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private var pagerAdapter: PagerAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen_slide)
        floatingbutton = findViewById(R.id.floatingbutton)
        // Instantiate a ViewPager and a PagerAdapter.
        mPager = findViewById<View>(R.id.pager) as ViewPager
        pagerAdapter = ScreenSlidePagerAdapter(supportFragmentManager)
        mPager!!.adapter = pagerAdapter
        floatingbutton?.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@ScreenSlidePagerActivity, MainScreen::class.java)
            startActivity(intent)
        })
        val handler = Handler()
        val Update = Runnable {
            if (currentPage == NUM_PAGES - 1) {
                currentPage = 0
            }
            mPager!!.setCurrentItem(currentPage++, true)
            val pager = findViewById<View>(R.id.pager) as ViewPager
            if (pagecount == 0) {
                pager.setBackgroundColor(Color.RED)
                pagecount++
            } else if (pagecount == 1) {
                pager.setBackgroundColor(Color.MAGENTA)
                pagecount++
            } else if (pagecount == 2) {
                pager.setBackgroundColor(Color.CYAN)
                pagecount = 0
            }
        }
        timer = Timer() // This will create a new Thread
        timer!!.schedule(object : TimerTask() {
            // task to be scheduled
            override fun run() {
                handler.post(Update)
            }
        }, DELAY_MS, PERIOD_MS)
    }

    override fun onBackPressed() {
        if (mPager!!.currentItem == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed()
        } else {
            // Otherwise, select the previous step.
            mPager!!.currentItem = mPager!!.currentItem - 1
        }
    }

    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private inner class ScreenSlidePagerAdapter(fm: FragmentManager?) : FragmentStatePagerAdapter(fm!!) {
        override fun getItem(position: Int): Fragment {
            return ScreenSlidePageFragment()
        }

        override fun getCount(): Int {
            return NUM_PAGES
        }
    }

    companion object {
        /**
         * The number of pages (wizard steps) to show in this demo.
         */
        private const val NUM_PAGES = 4
    }
}