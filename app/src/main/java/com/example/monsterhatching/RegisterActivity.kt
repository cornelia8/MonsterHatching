package com.example.monsterhatching

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // switch to login if you have an account
        val toLoginTextView: TextView = findViewById(R.id.login_redirect)
        toLoginTextView.setOnClickListener {
            val toLogIntent = Intent(this@RegisterActivity, LoginActivity::class.java)
            startActivity(toLogIntent)
        }

        // get username and start main activity
        val toMainActivity: Button = findViewById(R.id.button_register)
        toMainActivity.setOnClickListener {
            val startIntent = Intent(this@RegisterActivity, MainActivity::class.java)
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