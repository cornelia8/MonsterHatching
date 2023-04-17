package com.example.monsterhatching

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startIntent = intent
        val username = startIntent.getStringExtra("username")

        val usernameTextView : TextView = findViewById(R.id.user_name)
        usernameTextView.text = String.format(getString(R.string.display_username), username)

        // log out
        val logOutCue: ImageView = findViewById(R.id.logOut)
        logOutCue.setOnClickListener {
            val logOutIntent = Intent(this@MainActivity, LoginActivity::class.java)
            startActivity(logOutIntent)
        }

    }
}