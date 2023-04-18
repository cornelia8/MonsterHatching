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
import androidx.drawerlayout.widget.DrawerLayout
import com.example.monsterhatching.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var drawerLayout: DrawerLayout
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // handle navigation menu
        drawerLayout = findViewById(R.id.drawerLayout_id)
        actionBarDrawerToggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)

        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // constraint layout stuff
        val startIntent = intent
        val username = startIntent.getStringExtra("username")

        val usernameTextView : TextView = findViewById(R.id.user_name)
        usernameTextView.text = String.format(getString(R.string.display_username), username)

        val navigationView = findViewById<NavigationView>(R.id.navView)
        val headerView = navigationView.getHeaderView(0)
        val usernameNavTextView : TextView = headerView.findViewById<TextView>(R.id.nav_username)
        usernameNavTextView.text = String.format(getString(R.string.display_username), username)

        // log out
        val logOutCue: ImageView = findViewById(R.id.logOut)
        logOutCue.setOnClickListener {
            val logOutIntent = Intent(this@MainActivity, LoginActivity::class.java)
            startActivity(logOutIntent)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            true
        } else super.onOptionsItemSelected(item)
    }
}