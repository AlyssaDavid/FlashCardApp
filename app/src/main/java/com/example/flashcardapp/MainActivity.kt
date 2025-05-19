package com.example.flashcardapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        // Set the UI layout

                // start button click listener
                val startButton = findViewById<Button>(R.id.Startbutton)

                // Navigate to the quiz screen when clicked
                startButton.setOnClickListener {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent) // Open quiz screen
                    finish()
                // Close the welcome screen
                }
            }
        }
