package com.tutorial.machinetest.nestedlist

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.tutorial.machinetest.R
import com.tutorial.machinetest.activity.MainScreen

class NestedList : AppCompatActivity() {
    var father1: TextView? = null
    var father1_test1: TextView? = null
    var father1_test2: TextView? = null
    var linear_test1: LinearLayout? = null
    var linear_father1_test1: LinearLayout? = null
    var linear_father1_test2: LinearLayout? = null
    var m_father1: TextView? = null
    var m_father1_test1: TextView? = null
    var m_father1_test2: TextView? = null
    var m_linear_test1: LinearLayout? = null
    var m_linear_father1_test1: LinearLayout? = null
    var m_linear_father1_test2: LinearLayout? = null
    var w_m_father1: TextView? = null
    var w_m_father1_test1: TextView? = null
    var w_m_father1_test2: TextView? = null
    var w_m_linear_test1: LinearLayout? = null
    var w_m_linear_father1_test1: LinearLayout? = null
    var w_m_linear_father1_test2: LinearLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nested_list)
        linear_father1_test2 = findViewById(R.id.linear_father1_test2)
        father1_test2 = findViewById(R.id.father1_test2)
        linear_father1_test1 = findViewById(R.id.linear_father1_test1)
        father1_test1 = findViewById(R.id.father1_test1)
        father1 = findViewById(R.id.father1)
        linear_test1 = findViewById(R.id.linear_test1)


        //--------------Mother---------------------------
        m_linear_father1_test2 = findViewById(R.id.m_linear_father1_test2)
        m_father1_test2 = findViewById(R.id.m_father1_test2)
        m_linear_father1_test1 = findViewById(R.id.m_linear_father1_test1)
        m_father1_test1 = findViewById(R.id.m_father1_test1)
        m_father1 = findViewById(R.id.m_father1)
        m_linear_test1 = findViewById(R.id.m_linear_test1)

        //----------------------w_-------------------
        w_m_linear_father1_test2 = findViewById(R.id.w_m_linear_father1_test2)
        w_m_father1_test2 = findViewById(R.id.w_m_father1_test2)
        w_m_linear_father1_test1 = findViewById(R.id.w_m_linear_father1_test1)
        w_m_father1_test1 = findViewById(R.id.w_m_father1_test1)
        w_m_father1 = findViewById(R.id.w_m_father1)
        w_m_linear_test1 = findViewById(R.id.w_m_linear_test1)


        //-----------------------------------------
        father1?.setOnClickListener(View.OnClickListener {
            if (linear_test1?.getVisibility() == View.VISIBLE) {
                linear_test1?.setVisibility(View.GONE)
            } else {
                linear_test1?.setVisibility(View.VISIBLE)
            }
        })
        father1_test1?.setOnClickListener(View.OnClickListener { linear_father1_test1?.setVisibility(View.VISIBLE) })
        father1_test2?.setOnClickListener(View.OnClickListener { linear_father1_test2?.setVisibility(View.VISIBLE) })

        //---------------------------Mother----------------------------------------------------
        m_father1?.setOnClickListener(View.OnClickListener {
            if (m_linear_test1?.getVisibility() == View.VISIBLE) {
                m_linear_test1?.setVisibility(View.GONE)
            } else {
                m_linear_test1?.setVisibility(View.VISIBLE)
            }
        })
        m_father1_test1?.setOnClickListener(View.OnClickListener { m_linear_father1_test1?.setVisibility(View.VISIBLE) })
        m_father1_test2?.setOnClickListener(View.OnClickListener { m_linear_father1_test2?.setVisibility(View.VISIBLE) })

        //-----------------work--------------------
        w_m_father1?.setOnClickListener(View.OnClickListener {
            if (w_m_linear_test1?.getVisibility() == View.VISIBLE) {
                w_m_linear_test1?.setVisibility(View.GONE)
            } else {
                w_m_linear_test1?.setVisibility(View.VISIBLE)
            }
        })
        w_m_father1_test1?.setOnClickListener(View.OnClickListener {
            Log.i("w_m_father1_test1", "w_m_father1_test1")
            w_m_linear_father1_test1?.setVisibility(View.VISIBLE)
        })
        w_m_father1_test2?.setOnClickListener(View.OnClickListener {
            Log.i("w_m_father1_test2", "w_m_father1_test2")
            w_m_linear_father1_test2?.setVisibility(View.VISIBLE)
        })
    }

    override fun onBackPressed() {
        AlertDialog.Builder(this)
                .setTitle("Really Exit?")
                .setMessage("Are you sure you want to exit?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes) { arg0, arg1 ->
                    val intent = Intent(this@NestedList, MainScreen::class.java)
                    startActivity(intent)
                }.create().show()
    }
}