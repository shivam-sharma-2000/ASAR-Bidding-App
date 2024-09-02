package com.example.asartask.view_model
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.asartask.model.Header
import com.example.asartask.model.Question
import com.example.asartask.repo.HeaderRepo
import com.example.asartask.repo.QuestionRepo

class QuestionViewModel : ViewModel() {

    private val repositoryQuestion = QuestionRepo()
    private val _questions = MutableLiveData<List<Question>>()
    val questions: LiveData<List<Question>> get() = _questions

    private val repositoryHeader = HeaderRepo()
    private val _headers = MutableLiveData<List<Header>>()
    val headers: LiveData<List<Header>> get() = _headers

    private val _answers = MutableLiveData<List<Question>>().apply { value = mutableListOf() }
    val answers: LiveData<List<Question>> get() = _answers

    init {
        fetchQuestions()
        fetchHeaders()
    }

    private fun fetchQuestions() {
        _questions.value = repositoryQuestion.getQuestions()
    }

    private fun fetchHeaders() {
        _headers.value = repositoryHeader.getHeaders()
    }

    fun saveAnswer(answer: Question) {
        val currentItems = _answers.value?.toMutableList() ?: mutableListOf()
        currentItems.add(answer)
        _answers.value = currentItems
    }
}





















