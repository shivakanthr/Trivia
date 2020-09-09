package com.example.triva.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.triva.R
import kotlinx.android.synthetic.main.fragment_history.*
import kotlinx.coroutines.launch

class HistoryFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_history, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        lifecycleScope.launch {
            historyList.apply {
                layoutManager =  LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
                (activity as MainActivity).testViewModel.getUserList().observe(viewLifecycleOwner,
                    Observer {
                        adapter = HistoryAdapter(it)
                    })
            }
        }
    }
}