package com.example.asartask.screen

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.asartask.R
import com.example.asartask.model.Question
import com.example.asartask.view_model.QuestionViewModel
import com.squareup.picasso.Picasso

class YesNoActivity : AppCompatActivity() {

    var question : Question? = null
    var questionHeader : TextView? = null;
    var questionImage : ImageView? = null;
    var questionYes : Button? = null;
    var questionNo : Button? = null;
    var submit : Button? = null;
    var questionValue : TextView? = null;
    var investedValue : TextView? = null;
    var returnValue : TextView? = null;
    var seekBar : SeekBar? = null;
    private lateinit var viewModel: QuestionViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_yes_no)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.yes_no)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        viewModel = ViewModelProvider(this).get(QuestionViewModel::class.java)

        findIds();

        question = intent.getSerializableExtra("question") as? Question

        setData();

        questionYes!!.setOnClickListener(View.OnClickListener {
            questionYes!!.setBackgroundColor(Color.BLUE)
            questionNo!!.setBackgroundColor(Color.TRANSPARENT)
            question!!.questionAnswer = "Yes"
            question!!.questionAnswerValue = question!!.yesValue;
            questionValue!!.text =  question!!.yesValue.toString()
            investedValue!!.text =  question!!.yesValue.toString()
            returnValue!!.text =  (2 * question!!.yesValue).toString()
        })

        questionNo!!.setOnClickListener(View.OnClickListener {
            questionNo!!.setBackgroundColor(Color.GREEN)
            questionYes!!.setBackgroundColor(Color.TRANSPARENT)
            question!!.questionAnswer = "No"
            question!!.questionAnswerValue = question!!.noValue;
            questionValue!!.text =  question!!.noValue.toString()
            investedValue!!.text =  question!!.noValue.toString()
            returnValue!!.text =  (2 * question!!.noValue).toString()
        })

        submit!!.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, HomePageActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.putExtra("NEW_QUESTION", question)
            startActivityForResult(intent, 100)
            finish()
        })


        seekBar!!.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                // This method is called when the progress changes
                Log.d("SeekBar", "Progress: $progress")
                investedValue!!.text =  (progress * question!!.questionAnswerValue).toString()
                returnValue!!.text =  (progress * 2 * question!!.questionAnswerValue).toString()

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // This method is called when the user first touches the SeekBar
                Log.d("SeekBar", "Started tracking")
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // This method is called when the user stops touching the SeekBar
                Log.d("SeekBar", "Stopped tracking")
            }
        })

    }



    private fun findIds() {
        questionHeader = findViewById(R.id.question_header)
        questionImage = findViewById(R.id.question_image)
        questionYes = findViewById(R.id.question_yes)
        questionNo = findViewById(R.id.question_no)
        submit = findViewById(R.id.submit)
        questionValue = findViewById(R.id.question_value)
        investedValue = findViewById(R.id.invested_value)
        returnValue = findViewById(R.id.return_value)
        seekBar = findViewById(R.id.seekBar)
    }

    private fun setData() {
        questionHeader!!.text = question!!.questionHeader.toString()
        Picasso.get()
            .load(question!!.questionImage)
            .placeholder(R.drawable.ic_launcher_foreground) // Optional: Show this placeholder while loading
            .error(R.drawable.ic_launcher_foreground) // Optional: Show this image if loading fails
            .into(questionImage)
        questionYes!!.text = "Yes "+question!!.yesValue.toString()
        questionNo!!.text = "No "+question!!.noValue.toString()

        questionYes!!.setBackgroundColor(Color.BLUE)
        question!!.questionAnswer = "Yes"
        question!!.questionAnswerValue = question!!.yesValue;
        questionValue!!.text =  question!!.yesValue.toString()
        investedValue!!.text =  question!!.yesValue.toString()
        returnValue!!.text =  (2 * question!!.yesValue).toString()

    }
}