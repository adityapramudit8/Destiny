package com.hariobudiharjo.destiny.Adapter

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.hariobudiharjo.destiny.Activity.DetailFunStudyActivity
import com.hariobudiharjo.destiny.Model.funStudyModel
import com.hariobudiharjo.destiny.R

class FunStudyAdapter(private val context: Context, private val items: List<funStudyModel>) :
    RecyclerView.Adapter<FunStudyAdapter.ViewHolder>() {
    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        fun bindItems(data: funStudyModel) {

            val title: TextView = itemView.findViewById(R.id.title)
            val waktu: TextView = itemView.findViewById(R.id.waktu)
            val image: ImageView = itemView.findViewById(R.id.image_yt_row)

            title.text = data.matpel
            waktu.text = data.waktu


//            image.setImageResource(data.imageint!!)

            itemView.setOnClickListener {
                val intent = Intent(it.context, DetailFunStudyActivity::class.java)
                intent.putExtra("name", data.matpel)
                startActivity(it.context, intent, null)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FunStudyAdapter.ViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.rv_list_fun_study_item_row, parent, false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: FunStudyAdapter.ViewHolder, position: Int) {
        holder.bindItems(items[position])
    }
}