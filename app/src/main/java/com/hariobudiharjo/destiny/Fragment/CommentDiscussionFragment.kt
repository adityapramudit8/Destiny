package com.hariobudiharjo.destiny.Fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.hariobudiharjo.destiny.Adapter.CommentAdapter
import com.hariobudiharjo.destiny.Model.commentModel

import com.hariobudiharjo.destiny.R

class CommentDiscussionFragment : Fragment() {

    var comments = ArrayList<commentModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_comment_discussion, container, false)
        activity?.title = "Comment"
        val _recyclerView: RecyclerView = view.findViewById(R.id.rv_comment)
        _recyclerView.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)

        comments.add(
            commentModel(
                "Hario Budiharjo",
                "Apa tuh?",
                "30 Minute Ago",
                "Rp 3.500",
                "Rp 3.500"
            )
        )
        comments.add(
            commentModel(
                "Aditya Pramuditya",
                "Caranya yo?",
                "1 Hour Ago",
                "Rp 3.500",
                "Rp 3.500"
            )
        )
        comments.add(
            commentModel(
                "Ade Arta",
                "Waduh bingung juga-_-",
                "2 Hour Ago",
                "Rp 3.500",
                "Rp 3.500"
            )
        )


        val adapter = CommentAdapter(context!!, comments)
        _recyclerView.adapter = adapter

        return view
    }


}
