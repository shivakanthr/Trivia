package com.example.triva.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.triva.R
import com.example.triva.dataBase.data.GameData

class HistoryAdapter(private val mValues : List<GameData>) : RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    class HistoryViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val tvName: TextView = view.findViewById(R.id.name)
        val tvGame: TextView = view.findViewById(R.id.game)
        val rlQuestionList: RecyclerView = view.findViewById(R.id.question_list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.history_item,parent,false)
        return HistoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val item = mValues[position]
        holder.apply {
           tvName.text = "Name : " + item.name
            tvGame.text = "GAME " + (position+1).toString() + " : " + item.date
           rlQuestionList.apply {
               adapter = QuestionAnswerAdapter(item.questionAns)
               layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
           }
        }
    }

    override fun getItemCount(): Int = mValues.count()

}