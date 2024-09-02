package com.example.asartask.repo

import com.example.asartask.model.Question

class QuestionRepo {

    // Simulate a data source (e.g., API or local database)
    fun getQuestions(): List<Question> {
        return listOf(
            Question("Will Team A win the match?", "H2H T20", "https://upload.wikimedia.org/wikipedia/en/1/19/TATA_IPL_2024_Logo.png", 10.0, 8.0, null, 0.0, 0.0),
            Question("Will the top scorer of the match be from Team B?", "H2H T20", "https://upload.wikimedia.org/wikipedia/en/1/19/TATA_IPL_2024_Logo.png", 10.0, 8.0, null, 0.0, 0.0),
            Question("Will there be a century scored in this match?", "H2H T20", "https://upload.wikimedia.org/wikipedia/en/1/19/TATA_IPL_2024_Logo.png", 10.0, 8.0, null, 0.0, 0.0),
            Question("Will the match end in a tie?", "H2H T20", "https://upload.wikimedia.org/wikipedia/en/1/19/TATA_IPL_2024_Logo.png", 10.0, 8.0, null, 0.0, 0.0),
            Question("Will the team batting second win?", "H2H T20", "https://upload.wikimedia.org/wikipedia/en/1/19/TATA_IPL_2024_Logo.png", 10.0, 8.0, null, 0.0, 0.0),
        )
    }
}