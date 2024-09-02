package com.example.asartask.screen

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.asartask.MainActivity
import com.example.asartask.R
import com.example.asartask.adapter.AnswerAdapter
import com.example.asartask.adapter.HeaderAdapter
import com.example.asartask.model.Question
import com.example.asartask.view_model.QuestionViewModel

class HomePageActivity : AppCompatActivity() {
    var headerRV : RecyclerView? = null;
    var headerAdapter : HeaderAdapter? = null;

    var homeRV : RecyclerView? = null;
    var homeAdapter : AnswerAdapter? = null;
    var eventButton : Button? = null;
    private lateinit var viewModel: QuestionViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home_page)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        viewModel = ViewModelProvider(this).get(QuestionViewModel::class.java)

        findIds();

        setUpAdapter();

        eventButton!!.setOnClickListener(View.OnClickListener {
            val intent = Intent(it.context, MainActivity::class.java)
            it.context.startActivity(intent)
        })


        viewModel.answers.observe(this){
            homeAdapter = AnswerAdapter(viewModel.answers.value);
            homeRV!!.adapter = homeAdapter;
            homeAdapter!!.notifyDataSetChanged();
            println(it.size)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode ==100 && resultCode == Activity.RESULT_OK) {
            val newQuestion = data?.getSerializableExtra("NEW_QUESTION")
            newQuestion?.let {
                viewModel.saveAnswer(it as Question) // Update LiveData in ViewModel
            }
        }
    }

    private fun setUpAdapter() {
        // Set Up Header RV Adapter
        headerRV!!.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        headerAdapter = HeaderAdapter(viewModel.headers.value);
        headerRV!!.adapter = headerAdapter;

        homeRV!!.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        homeAdapter = AnswerAdapter(viewModel.answers.value);
        homeRV!!.adapter = homeAdapter;
    }


    private fun findIds() {
        homeRV = findViewById<RecyclerView>(R.id.home_rv);
        headerRV = findViewById<RecyclerView>(R.id.header_rv);
        eventButton = findViewById<Button>(R.id.event);
    }
}