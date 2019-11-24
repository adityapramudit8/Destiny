package com.hariobudiharjo.destiny.Fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.hariobudiharjo.destiny.Adapter.MateriAdapter
import com.hariobudiharjo.destiny.Model.materiModel

import com.hariobudiharjo.destiny.R

class ListMateriFragment : Fragment() {
    var materis = ArrayList<materiModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_list_materi, container, false)
        activity?.title = "List Materi"
        val _recyclerView: RecyclerView = view.findViewById(R.id.rv_materi)
        _recyclerView.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)

        materis.add(
            materiModel(
                "Fisika",
                "Fisika Dasar",
                "Rp 3.500",
                "Rp 3.500",
                "Rp 3.500"
            )
        )
        materis.add(
            materiModel(
                "Matematika",
                "Matematika Dasar",
                "Rp 3.500",
                "Rp 3.500",
                "Rp 3.500"
            )
        )


        val adapter = MateriAdapter(context!!, materis)
        _recyclerView.adapter = adapter

        return view
    }


}
