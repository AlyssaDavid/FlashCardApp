package com.example.flashcardapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class score : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_score)

        val score = intent.getIntExtra("score", 0)
        val wrongList = intent.getStringArrayListExtra("wrongQuestions")

        val scoreText = findViewById<TextView>(R.id.score_text)
        val wrongText = findViewById<TextView>(R.id.wrong_text)
        val restartButton = findViewById<Button>(R.id.restart_button)

        scoreText.text = "Your score: $score / 4"

        if (wrongList.isNullOrEmpty()) {
            wrongText.text = "No wrong questions."
        } else {
            val wrongFormatted =
                wrongList.joinToString("\n-", prefix = "Questions you got wrong:\n-")
            wrongText.text = wrongFormatted

            restartButton.setOnClickListener {
                val intent = Intent(this, MainActivity::class.java)
                // clear the back stack so the user cant press "back"to return to results page
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
                finish()
            }
        }
    }
}





