package com.example.guessme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.guessme.Rank

class ReadRankActivity : AppCompatActivity() {

    val ranklist: ArrayList<Rank> = arrayListOf()

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    val context : Context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_read_rank)

    }

    inner class rank_control {
        fun show_Rank(context: Context) {
            viewManager = LinearLayoutManager(context)
            viewAdapter = RankAdapter(ranklist)

            recyclerView = findViewById<RecyclerView>(R.id.rv_rank).apply {
                setHasFixedSize(true)
                layoutManager = viewManager
                adapter = viewAdapter
            }
        }
    }
}




