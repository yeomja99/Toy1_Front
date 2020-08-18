package com.example.guessme

import android.content.Context
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.guessme.data.Quiz
import com.example.guessme.util.Constants
import kotlinx.android.synthetic.main.activity_read_quiz.*

class ReadQuizActivity : AppCompatActivity() {

    val readQuizList: ArrayList<Quiz> = arrayListOf() // 퀴즈 리스트 담을 배열 생성
    val my_answer_list: ArrayList<Int> = arrayListOf(-1, -1, -1, -1, -1)
    var nickname: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_read_quiz)

        nickname = intent.getStringExtra("nickname")
        tv_cq_title.setText(String.format("%s님의 퀴즈를 풀어보세요!", nickname))
        Solve_Control().GET_QUIZ(nickname)
    }

    inner class Solve_Control() {

        // 닉네임에 해당하는 퀴즈 바로 받아오기
        fun GET_QUIZ(nickname: String) {
            val quiz_url = Constants.BASE_URL + "/quizzes/" + nickname
            asynctask().excute("0", quiz_url)
        }

        fun POST_SCORE(nickname: String, score: String) {
            val quiz_url = Constants.BASE_URL + "/quizzes/" + nickname
            asynctask().excute("1", quiz_url, score)
        }
    }

    inner class asynctask : AsyncTask<String, Void, String>() {
        // state = 1 -> GET : 퀴즈 조회
        // state = 2 -> POST : 점수 전송
        var state: Int = -1
        var score: String = ""


    }

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
