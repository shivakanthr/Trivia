package com.example.triva.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.triva.R
import com.example.triva.dataBase.data.QuestionAnswer
import kotlinx.android.synthetic.main.fragment_question_two.*

class QuestionTwoFragment : Fragment(), View.OnClickListener{

    private val optionsList = mutableListOf<String>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_question_two, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkbox1.setOnClickListener(this)
        checkbox2.setOnClickListener(this)
        checkbox3.setOnClickListener(this)
        checkbox4.setOnClickListener(this)
        navigate()
    }
    
    private fun onCheckboxClicked(view: View) {
        if (view is CheckBox) {
            val checked: Boolean = view.isChecked
            when (view.id) {
                R.id.checkbox1 -> {
                    if (checked) {
                        optionsList.add((view.text.toString()))
                    } else {
                        if(optionsList.contains(view.text.toString()))
                            optionsList.remove(view.text.toString())
                    }
                }
                R.id.checkbox2 -> {
                    if (checked) {
                        optionsList.add((view.text.toString()))
                    } else {
                        if(optionsList.contains(view.text.toString()))
                            optionsList.remove(view.text.toString())
                    }
                }
                R.id.checkbox3 -> {
                    if (checked) {
                        optionsList.add((view.text.toString()))
                    } else {
                        if(optionsList.contains(view.text.toString()))
                            optionsList.remove(view.text.toString())
                    }
                }
                else -> {
                    if (checked) {
                        optionsList.add((view.text.toString()))
                    } else {
                        if(optionsList.contains(view.text.toString()))
                            optionsList.remove(view.text.toString())
                    }
                }
            }
        }

    }

    private fun navigate() {
        next.setOnClickListener {
            val mQuestionAnswer = QuestionAnswer()
            mQuestionAnswer.question = question_two_label.text.toString()
            mQuestionAnswer.answer = optionsList
            if((activity as MainActivity).testViewModel.userData.questionAns.size == 1){
                (activity as MainActivity).testViewModel.userData.questionAns.add(mQuestionAnswer)
            } else{
                (activity as MainActivity).testViewModel.userData.questionAns[1] = (mQuestionAnswer)
            }
            if(optionsList.size < 2 ) {
              Toast.makeText(context,"Please Select atleast two colors ",Toast.LENGTH_SHORT).show()
            } else {
                findNavController().navigate(R.id.action_questionTwoFragment_to_summaryFragment)
            }
        }
    }

    override fun onClick(v: View?) {
        v?.let {
            onCheckboxClicked(it)
        }
    }
}