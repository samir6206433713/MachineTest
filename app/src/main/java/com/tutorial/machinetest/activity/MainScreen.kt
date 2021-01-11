package com.tutorial.machinetest.activity

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.tutorial.machinetest.R
import com.tutorial.machinetest.fragment.Home
import com.tutorial.machinetest.map.MainActivity
import com.tutorial.machinetest.nestedlist.NestedList

class MainScreen : AppCompatActivity() {
    var bottom_navigation: BottomNavigationView? = null
    var fragment1: Fragment? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)
        loadFragment(Home())
        fragment1 = Home()
        bottom_navigation = findViewById(R.id.bottom_navigation)
        bottom_navigation?.setOnNavigationItemSelectedListener(object : BottomNavigationView.OnNavigationItemSelectedListener {
            var fragment: Fragment? = null
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when (item.itemId) {
                    R.id.home -> fragment = Home()
                    R.id.map -> {
                        val intent = Intent(this@MainScreen, MainActivity::class.java)
                        startActivity(intent)
                    }
                    R.id.control -> {
                        val intent2 = Intent(this@MainScreen, NestedList::class.java)
                        startActivity(intent2)
                    }
                }
                return loadFragment(fragment)
            }
        })
        // tv_deposite.setOnClickListener(this);
    }

    private fun loadFragment(fragment: Fragment?): Boolean {
        //switching fragment
        if (fragment != null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame, fragment)
                    .commit()
            return true
        }
        return false
    }
}