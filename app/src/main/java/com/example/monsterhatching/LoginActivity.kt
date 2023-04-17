package com.example.monsterhatching

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // switch to register if no account
        val toRegisterTextView: TextView = findViewById(R.id.register_redirect)
        toRegisterTextView.setOnClickListener {
            val toRegIntent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(toRegIntent)
        }

        // get username and start main activity
        val toMainActivity: Button = findViewById(R.id.button_login)
        toMainActivity.setOnClickListener {
            val startIntent = Intent(this@LoginActivity, MainActivity::class.java)
            val usernameInput = findViewById<EditText>(R.id.username_text_field)
            val username = usernameInput.text.toString()

            if (username.isEmpty()) {
                Toast.makeText(this, "Please enter a username", Toast.LENGTH_SHORT).show()
            }
            else {
                startIntent.putExtra("username", username)
                startActivity(startIntent)
            }
        }

    }
}