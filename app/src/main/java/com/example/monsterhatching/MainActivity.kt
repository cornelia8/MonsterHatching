package com.example.monsterhatching

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import com.example.monsterhatching.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // handle navigation menu
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            toggle = ActionBarDrawerToggle(this@MainActivity, drawerLayout, R.string.open, R.string.close)
            drawerLayout.addDrawerListener(toggle)
            toggle.syncState()

            supportActionBar?.setDisplayHomeAsUpEnabled(true)

            navView.setNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.home -> { true }
                    R.id.inventory -> { true }
                    R.id.board -> { true }
                    else -> false
                }
            }
        }

        fun onOptionsItemSelected(item: MenuItem): Boolean {
            if (toggle.onOptionsItemSelected(item)) {
                true
            }
            return super.onOptionsItemSelected(item)
        }

        // constraint layout stuff
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