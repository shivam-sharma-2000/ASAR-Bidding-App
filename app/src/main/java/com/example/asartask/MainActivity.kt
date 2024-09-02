package com.example.asartask

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.asartask.adapter.HeaderAdapter
import com.example.asartask.adapter.QuestionAdapter
import com.example.asartask.view_model.QuestionViewModel

class MainActivity : AppCompatActivity(){

    var questionRV : RecyclerView? = null;
    var questionAdapter : QuestionAdapter? = null;
    private val viewModel: QuestionViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContentView(R.layout.activity_main)

        findIds();

        setUpAdapter();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right ,0)
            insets
        }
    }

    private fun setUpAdapter() {
        // Set Up Question RV Adapter
        questionRV!!.layoutManager = LinearLayoutManager(this);
        questionAdapter = QuestionAdapter(viewModel.questions.value);
        questionRV!!.adapter = questionAdapter;
    }

    private fun findIds() {
        questionRV = findViewById<RecyclerView>(R.id.question_rv);
    }

}