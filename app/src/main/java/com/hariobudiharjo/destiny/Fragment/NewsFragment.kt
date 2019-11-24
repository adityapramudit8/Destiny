package com.hariobudiharjo.destiny.Fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.hariobudiharjo.destiny.Adapter.FunStudyAdapter
import com.hariobudiharjo.destiny.Adapter.NewsAdapter
import com.hariobudiharjo.destiny.Model.funStudyModel
import com.hariobudiharjo.destiny.Model.newsModel

import com.hariobudiharjo.destiny.R

class NewsFragment : Fragment() {

    var news = ArrayList<newsModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_news, container, false)

        activity?.title = "News"
        val _recyclerView: RecyclerView = view.findViewById(R.id.rv_news)
        _recyclerView.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)

        news.add(
            newsModel(
                "Biologi",
                "1",
                "1 day ago",
                "",
                "Lorem ipsum dolor",
                "Lorem ipsum dolor"
            )
        )
        news.add(
            newsModel(
                "Biologi",
                "1",
                "1 day ago",
                "",
                "Lorem ipsum dolor",
                "Lorem ipsum dolor"
            )
        )


        val adapter = NewsAdapter(context!!, news)
        _recyclerView.adapter = adapter

        return view
    }


}
