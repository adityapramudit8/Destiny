package com.hariobudiharjo.destiny.Fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.hariobudiharjo.destiny.Adapter.DiscussionAdapter
import com.hariobudiharjo.destiny.Model.discussionModel

import com.hariobudiharjo.destiny.R

class DiscussionFragment : Fragment() {

    var discussions = ArrayList<discussionModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_discussion, container, false)
        activity?.title = "Discussion"
        val _recyclerView: RecyclerView = view.findViewById(R.id.rv_discussion)
        _recyclerView.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)

        discussions.add(
            discussionModel(
                "Ekonomi",
                "Apa itu money laundry ?",
                "Rp 3.500",
                "Rp 3.500",
                "Rp 3.500"
            )
        )
        discussions.add(
            discussionModel(
                "Geografi",
                "Penyebab Utama Terjadinya gempa ?",
                "Rp 3.500",
                "Rp 3.500",
                "Rp 3.500"
            )
        )


        val adapter = DiscussionAdapter(context!!, discussions)
        _recyclerView.adapter = adapter

        return view

    }


}
