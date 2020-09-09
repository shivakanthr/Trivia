package com.example.triva.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.triva.R
import com.example.triva.viewmodel.TestViewModel
import kotlinx.android.synthetic.main.fragment_name.*


class NameFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_name, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListener()
    }

    private fun setListener() {
        next.setOnClickListener {
            val mName = name_edit.text.toString()
            if (mName.length >= 3 ) {
                (activity as MainActivity).testViewModel.userData.name = mName
                findNavController().navigate(R.id.action_nameFragment_to_questionOneFragment)
            } else {
                Toast.makeText(context,"Please valid name",Toast.LENGTH_LONG).show()
            }
        }
    }
}