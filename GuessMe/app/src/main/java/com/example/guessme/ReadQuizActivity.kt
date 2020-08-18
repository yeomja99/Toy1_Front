package com.example.guessme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.guessme.data.Quiz

class ReadQuizActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_read_quiz)

        val readQuizList: ArrayList<Quiz> = arrayListOf()

        //quiz_url 작성!!
        //val quiz_url = ?

        lateinit var recyclerView: RecyclerView
        lateinit var viewAdapter: RecyclerView.Adapter<*>
        lateinit var viewManager: RecyclerView.LayoutManager
        val context: Context = this

        // view 보기 위한 초기화
//        recyclerView = findViewById<RecyclerView>(R.id.read_quiz)
//        for (i in 0 until 5){
//            readQuizList.add(Quiz(1,"퀴즈가 나온다리",1))
//        }
//        val adapter = ReadQuizAdapter(context, readQuizList)
//        recyclerView.adapter = adapter
//        recyclerView.layoutManager = LinearLayoutManager(this@ReadQuizActivity)

    }
}
