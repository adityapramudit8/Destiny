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
import com.hariobudiharjo.destiny.Model.funStudyModel

import com.hariobudiharjo.destiny.R

class FunStudyFragment : Fragment() {

    var funStudys = ArrayList<funStudyModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_fun_study, container, false)
        activity?.title = "Fun Study"
        val _recyclerView: RecyclerView = view.findViewById(R.id.rv_fun_study)
        _recyclerView.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)

        funStudys.add(
            funStudyModel(
                "Biologi",
                "1",
                "1 day ago",
                "",
                "Lorem ipsum dolor",
                "7 Chicken",
                "latlang",
                "083813188111",
                "x"
            )
        )
        funStudys.add(
            funStudyModel(
                "Matematika",
                "1",
                "3 day ago",
                "",
                "Lorem ipsum dolor",
                "7 Chicken",
                "latlang",
                "083813188111",
                "x"
            )
        )


        val adapter = FunStudyAdapter(context!!, funStudys)
        _recyclerView.adapter = adapter

        return view
    }


}
