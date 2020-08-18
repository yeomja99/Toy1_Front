package com.example.guessme

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.guessme.data.Quiz

class CreateQuizAdapter(val context: Context, val create_quiz_list: ArrayList<Quiz>) :
    RecyclerView.Adapter<CreateQuizAdapter.holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CreateQuizAdapter.holder {
        val view = LayoutInflater.from(context).inflate(R.layout.quiz_item, parent, false)
        return holder(view)
    }

    override fun getItemCount(): Int {
        return create_quiz_list.size
    }

    override fun onBindViewHolder(p0: holder, p1: Int) {
        p0.bind(create_quiz_list[p1], p1)
    }

    inner class holder(view: View) : RecyclerView.ViewHolder(view) {
        val tv_content = view.findViewById<TextView>(R.id.create_content)
        val iv_yes = view.findViewById<Button>(R.id.yes_button)
        val iv_no = view.findViewById<Button>(R.id.no_button)

        fun bind(quiz: Quiz, index: Int) {
            // 질문이 없는 경우
            if (quiz.content == "") {
                tv_content?.setText("질문이 없습니다.")
            } else {
                tv_content?.setText(quiz.content)
            }

            fun setYes() {
                iv_yes.setBackgroundColor(Color.parseColor("#9DAAFF"))
                iv_no.setBackgroundColor(Color.parseColor("#ededed"))
                quiz.answer = 1
            }

            fun setNo() {
                iv_yes.setBackgroundColor(Color.parseColor("#ededed"))
                iv_no.setBackgroundColor(Color.parseColor("#FE5959"))
                quiz.answer = 0
            }

            fun clearYesNo() {
                iv_yes.setBackgroundColor(Color.parseColor("#ededed"))
                iv_no.setBackgroundColor(Color.parseColor("#ededed"))
                quiz.answer = -1
            }

            clearYesNo()

            iv_yes.setOnClickListener {
                if (quiz.answer == 1) {
                    clearYesNo()
                } else {
                    setYes()
                }
            }

            iv_no.setOnClickListener {
                if(quiz.answer==0) {
                    clearYesNo()
                } else{
                    setNo()
                }
            }
        }

    }
}


//#FE5959 : NO ACT
//#9DAAFF : YES ACT


//            iv_yes.setOnClickListener {//answer=1로 바꾸기(yes 활성화)
//                if (quiz.answer != 1) {
//                    iv_yes.setBackgroundColor(Color.parseColor("#9DAAFF"))
//                    iv_no.setBackgroundColor(Color.parseColor("#ededed"))
//                    quiz.answer = 1
//                } else {
//                    iv_yes.setBackgroundColor(Color.parseColor("#ededed"))
//                    quiz.answer = -1
//                }
//
//            }
//
//            iv_no.setOnClickListener {
//                if (quiz.answer != 0) { // 1이나 -1 일 때
//                    iv_no.setBackgroundColor(Color.parseColor("#FE5959"))
//                    iv_yes.setBackgroundColor(Color.parseColor("#ededed"))
//                    quiz.answer = 0
//                } else {
//                    iv_no.setBackgroundColor(Color.parseColor("#ededed"))
//                    quiz.answer = -1
//                }
//            }
