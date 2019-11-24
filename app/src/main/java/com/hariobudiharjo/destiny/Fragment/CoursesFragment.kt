package com.hariobudiharjo.destiny.Fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.hariobudiharjo.destiny.Adapter.CoursesAdapter
import com.hariobudiharjo.destiny.Model.coursesModel

import com.hariobudiharjo.destiny.R

class CoursesFragment : Fragment() {


    var courses = ArrayList<coursesModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_courses, container, false)
        activity?.title = "Course"
        val _recyclerView: RecyclerView = view.findViewById(R.id.rv_courses)
        _recyclerView.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)

        courses.add(
            coursesModel(
                "Biologi",
                "The study of living organisms",
                "Rp 3.500",
                "Rp 3.500",
                "Rp 3.500"
            )
        )
        courses.add(
            coursesModel(
                "Kimia",
                "The study of interactions of substances",
                "Rp 3.500",
                "Rp 3.500",
                "Rp 3.500"
            )
        )


        val adapter = CoursesAdapter(context!!, courses)
        _recyclerView.adapter = adapter

        return view
    }


}
