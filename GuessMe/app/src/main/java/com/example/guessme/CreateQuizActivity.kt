package com.example.guessme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.guessme.data.Quiz

class CreateQuizActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_quiz_acitivity)
        val createQuizList: ArrayList<Quiz> = arrayListOf()

        //quiz_url 작성!!
        //val quiz_url = ?

        lateinit var recyclerView: RecyclerView
        lateinit var viewAdapter: RecyclerView.Adapter<*>
        lateinit var viewManager: RecyclerView.LayoutManager
        val context: Context = this

        for (i in 0 until 5){
            createQuizList.add(Quiz(1,"퀴즈가 나온다리",1))
        }

        val adapter = CreateQuizAdapter(context, createQuizList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this@CreateQuizActivity)
    }



}



