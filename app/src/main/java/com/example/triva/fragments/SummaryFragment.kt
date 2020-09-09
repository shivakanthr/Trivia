package com.example.triva.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.triva.R
import com.example.triva.dataBase.data.GameData
import kotlinx.android.synthetic.main.fragment_summary.*
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class SummaryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_summary, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        name.text = "Name : " +(activity as MainActivity).testViewModel.userData.name
        question_answer_list.apply {
            layoutManager =  LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = QuestionAnswerAdapter((activity as MainActivity).testViewModel.userData.questionAns)
        }

        finish.setOnClickListener {
            val today = Date()
            val format = SimpleDateFormat("dd'th'-MMMM-hh:mm a")
            val dateToStr: String = format.format(today)
            (activity as MainActivity).testViewModel.userData.date = dateToStr
            lifecycleScope.launch {
                (activity as MainActivity).testViewModel.insertData((activity as MainActivity).testViewModel.userData)
            }
            (activity as MainActivity).testViewModel.userData = GameData()
            findNavController().navigate(R.id.action_summaryFragment_to_nameFragment)
        }
        history.setOnClickListener {
            findNavController().navigate(R.id.action_summaryFragment_to_historyFragment)
        }
    }
}