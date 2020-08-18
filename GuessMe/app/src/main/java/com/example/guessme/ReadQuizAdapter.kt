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

class ReadQuizAdapter (val context: Context, val read_quiz_list:ArrayList<Quiz>)
    :RecyclerView.Adapter<ReadQuizAdapter.holder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReadQuizAdapter.holder {
        val view = LayoutInflater.from(context).inflate(R.layout.quiz_item, parent, false)
        return holder(view)
    }

    override fun getItemCount(): Int {
        return read_quiz_list.size
    }

    override fun onBindViewHolder(holder: ReadQuizAdapter.holder, position: Int) {
        holder.bind(read_quiz_list[position],position)
    }

    inner class holder(view: View): RecyclerView.ViewHolder(view){
        val tv_content = view.findViewById<TextView>(R.id.create_content)
        val iv_yes = view.findViewById<Button>(R.id.yes_button)
        val iv_no = view.findViewById<Button>(R.id.no_button)

        fun bind(quiz:Quiz, index:Int){
            if (quiz.content ==""){
                tv_content?.setText("질문이 없습니다.")
            }else{
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


