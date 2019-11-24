package com.hariobudiharjo.destiny.Fragment


import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hariobudiharjo.destiny.Activity.ChatBotActivity
import com.hariobudiharjo.destiny.Activity.MainActivity

import com.hariobudiharjo.destiny.R

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val fab = view.findViewById<FloatingActionButton>(R.id.fabhome)
        fab.setOnClickListener {
            val intent = Intent(context, ChatBotActivity::class.java)
            startActivity(intent)
        }
        activity?.title = "Home"
        return view
    }


}
