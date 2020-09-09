package com.example.triva.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.triva.R
import com.example.triva.dataBase.data.QuestionAnswer
import com.example.triva.viewmodel.TestViewModel
import kotlinx.android.synthetic.main.fragment_question_one.*

class QuestionOneFragment : Fragment() {

    private lateinit var mSelectedOption :String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_question_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListener()
    }

    private fun setListener() {
        radio_group.setOnCheckedChangeListener() { group, checkedId ->
            mSelectedOption = when (checkedId) {
                R.id.option_one -> option_one.text.toString()
                R.id.option_two -> option_two.text.toString()
                R.id.option_three -> option_three.text.toString()
                else -> option_four.text.toString()
            }
        }

        next.setOnClickListener {
            val mQuestionAnswer = QuestionAnswer()
            mQuestionAnswer.question = question_one_label.text.toString()
            mQuestionAnswer.answer = listOf(mSelectedOption)
            if((activity as MainActivity).testViewModel.userData.questionAns.size == 0)
                (activity as MainActivity).testViewModel.userData.questionAns.add(mQuestionAnswer)
            else {
                (activity as MainActivity).testViewModel.userData.questionAns[0] = (mQuestionAnswer)
            }
            findNavController().navigate(R.id.action_questionOneFragment_to_questionTwoFragment)
        }
    }

}