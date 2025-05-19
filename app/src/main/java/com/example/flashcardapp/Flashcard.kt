package com.example.flashcardapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Flashcard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_flashcard)

        val questions = arrayOf(
            "The Declaration of Independance was signed in 1779",
            "world War 1 ended in 1939",
            "The great wall of China was built in only one year",
            "Abraham lincoln was the 1st president of the USA",
        )

        val answers = booleanArrayOf(
            true,
            false,
            false,
            true,
        )

        var currentIndex = 0
        var score = 0
        var wrongQuestions = ArrayList<String>()

        fun updateQuestion() {
            if (currentIndex < questions.size) {
                val questionText = findViewById<TextView>(R.id.questionText)
                questionText.text = questions[currentIndex]
            }
        }

        fun checkAnswer(userAnswer: Boolean) {
            val correctAnswer = answers[currentIndex]
            val currentQuestion = questions[currentIndex]

            if (userAnswer == correctAnswer) {
                Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
                score++
            } else {
                Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show()
                wrongQuestions.add(questions[currentIndex])
            }
            currentIndex++
            if (currentIndex < questions.size) {
                updateQuestion()
            } else {
                val intent = Intent(this, score::class.java)
                intent.putExtra("score", score)
                intent.putStringArrayListExtra("wrongQuestions", wrongQuestions)
                startActivity(intent)
                finish()
            }
        }

        val trueButton = findViewById<Button>(R.id.trueButton)
        val falseButton = findViewById<Button>(R.id.falseButton)
        val nextButton = findViewById<Button>(R.id.nextButton)

        trueButton.setOnClickListener {
            checkAnswer(true)
        }

        falseButton.setOnClickListener {
            checkAnswer(false)
        }

        nextButton.setOnClickListener {
            if (currentIndex < questions.size) {
                checkAnswer(false)
            } else {
                Toast.makeText(this, "No more questions!", Toast.LENGTH_SHORT).show()
                updateQuestion()
            }
        }
    }
}
