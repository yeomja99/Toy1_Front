package com.example.guessme

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.guessme.Rank

class RankAdapter(private val ranklist: ArrayList<Rank>) :
    RecyclerView.Adapter<RankAdapter.RankViewHolder>(){

    class RankViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val tv_number = itemView?.findViewById<TextView>(R.id.tv_rank_number)
        val tv_user = itemView?.findViewById<TextView>(R.id.tv_rank_user)
        val tv_score = itemView?.findViewById<TextView>(R.id.tv_rank_score)

        fun bind (rank: Rank, index : Int) {
            tv_number.setText(rank.number.toString())
            tv_user.setText(rank.user)
            tv_score.setText(rank.score.toString())

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RankViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.rank_item, parent, false)
        return RankViewHolder(itemView)
    }

    override fun getItemCount() = ranklist.size

    override fun onBindViewHolder(holder: RankViewHolder, position: Int) {
        holder?.bind(ranklist[position], position)
    }
}