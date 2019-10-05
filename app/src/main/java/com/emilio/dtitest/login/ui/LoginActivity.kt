package com.emilio.dtitest.login.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import com.emilio.dtitest.R
import com.emilio.dtitest.home.ui.HomeActivity
import com.emilio.dtitest.login.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.android.viewmodel.ext.android.viewModel

class LoginActivity : AppCompatActivity() {

    private val viewModel: LoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    override fun onResume() {
        super.onResume()

        login_button.setOnClickListener {
            if (isValid()) {
                viewModel.login(
                    username_field.editText?.text?.toString()?.trim() ?: "",
                    password_field?.editText?.text?.toString() ?: ""
                )
            }
        }

        register_button.setOnClickListener {
            if (isValid()) {
                viewModel.register(
                    username_field.editText?.text?.toString()?.trim() ?: "",
                    password_field?.editText?.text?.toString() ?: ""
                )
            }
        }

        viewModel.error.observe(this, Observer {
            if(!it.isNullOrEmpty()) {
                Toast.makeText(this, it, Toast.LENGTH_LONG).show()
            }
        })

        viewModel.logged.observe(this, Observer {
            if (it == true) {
                startActivity(Intent(this, HomeActivity::class.java))
                finish()
            }
        })

        viewModel.showLoading.observe(this, Observer {
            when (it) {
                true -> {
                    progress_bar.run {
                        visibility = View.VISIBLE
                        show()
                    }
                    buttons_container.visibility = View.GONE
                }
                else -> {
                    progress_bar.run {
                        visibility = View.GONE
                        hide()
                    }
                    buttons_container.visibility = View.VISIBLE
                }
            }
        })
    }

    private fun isValid(): Boolean {
        if (username_field.editText?.text.toString().trim().isEmpty()) {
            Toast.makeText(
                this,
                resources.getString(R.string.enter_valid_username),
                Toast.LENGTH_SHORT
            )
                .show()
            return false
        } else if (password_field.editText?.text.toString().isEmpty()) {
            Toast.makeText(
                this,
                resources.getString(R.string.enter_valid_password),
                Toast.LENGTH_SHORT
            )
                .show()
            return false
        }

        return true
    }
}
