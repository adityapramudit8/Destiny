package com.hariobudiharjo.destiny.Fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.hariobudiharjo.destiny.Adapter.SoalAdapter
import com.hariobudiharjo.destiny.Model.soalModel

import com.hariobudiharjo.destiny.R

class ListSoalFragment : Fragment() {

    var soals = ArrayList<soalModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list_soal, container, false)
        val _recyclerView: RecyclerView = view.findViewById(R.id.rv_soal)
        _recyclerView.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)

        soals.add(
            soalModel(
                "Fisika",
                "Wujud unsur - unsur halogen ?",
                "Rp 3.500",
                "~5 Menit",
                "Rp 3.500"
            )
        )
        soals.add(
            soalModel(
                "Matematika",
                "Wujud unsur - unsur halogen ?",
                "Rp 3.500",
                "~10 Menit",
                "Rp 3.500"
            )
        )


        val adapter = SoalAdapter(context!!, soals)
        _recyclerView.adapter = adapter

        return view
    }


}
