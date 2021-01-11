package com.tutorial.machinetest.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ScrollView
import androidx.fragment.app.Fragment
import com.tutorial.machinetest.R

class ScreenSlidePageFragment : Fragment() {
    var scrollView: ScrollView? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(
                R.layout.fragment_screen_slide_page, container, false) as ViewGroup
    }
}