package com.minipro.main_mini

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Find the login button by its ID
        val loginButton = findViewById<Button>(R.id.login_button)

        // Set up click listener for the login button
        loginButton.setOnClickListener {
            // Create an intent to start the DashboardActivity
            val intent = Intent(this@MainActivity, DashboardActivity::class.java)
            // Start the DashboardActivity
            startActivity(intent)
        }
    }
}
