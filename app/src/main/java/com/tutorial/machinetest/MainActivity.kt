package com.tutorial.machinetest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tutorial.machinetest.presenter.SignUpPresenter
import com.tutorial.machinetest.presenter.SignUpPresenter.SignUpPresenterView

class MainActivity : AppCompatActivity(), SignUpPresenterView {
    var signUpPresenter: SignUpPresenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun getErrorSignUpPresenter(error: String?) {}
    override fun responceSignup(resonse: String?) {}
}