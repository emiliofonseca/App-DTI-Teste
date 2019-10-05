package com.emilio.dtitest.home.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.emilio.dtitest.R
import com.emilio.dtitest.home.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.activity_home.*
import org.koin.android.ext.android.inject

class HomeActivity : AppCompatActivity() {

    private val viewModel: HomeViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

    override fun onResume() {
        super.onResume()

        viewModel.showLoading.observe(this, Observer {
            when (it) {
                true -> {
                    progress_bar.visibility = View.VISIBLE
                    text.visibility = View.GONE
                }
                false -> {
                    progress_bar.visibility = View.GONE
                    text.visibility = View.VISIBLE
                }
            }
        })

        viewModel.value.observe(this, Observer {
            text.text = it
        })

        viewModel.getValues()
    }
}
