package com.example.triva.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.triva.R
import com.example.triva.dataBase.data.QuestionAnswer

class QuestionAnswerAdapter(private val mValues:List<QuestionAnswer>) :RecyclerView.Adapter<QuestionAnswerAdapter.QuestionAnswerViewHolder>() {

    class QuestionAnswerViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val tvQuestion: TextView = view.findViewById(R.id.question)
        val tvAnswer: TextView = view.findViewById(R.id.answer)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionAnswerViewHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.question_answer,parent,false)
        return QuestionAnswerViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuestionAnswerViewHolder, position: Int) {
        val item = mValues[position]
        holder.apply {
            tvQuestion.text = item.question
            tvAnswer.text = item.answer.joinToString { it }
        }
    }

    override fun getItemCount(): Int = mValues.count()

}