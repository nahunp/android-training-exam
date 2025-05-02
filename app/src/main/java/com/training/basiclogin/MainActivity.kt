package com.training.basiclogin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private val presenter: MainPresenter by lazy {
        MainPresenter()
    }

    private val inputUser: EditText by lazy {
        findViewById(R.id.user_edit_text)
    }
    private val inputPassword: EditText by lazy {
        findViewById(R.id.password_edit_text)
    }

    private val addButton: Button by lazy {
        findViewById(R.id.login_button)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        presenter.onInit()
        addButton.setOnClickListener {
            val user = inputUser.text.toString()
            val password = inputPassword.text.toString()
            if (presenter.validateLogin(user, password)) {
                val intent = Intent(this, NewActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Validate e-mail and password", Toast.LENGTH_LONG).show()
            }
        }
    }
}