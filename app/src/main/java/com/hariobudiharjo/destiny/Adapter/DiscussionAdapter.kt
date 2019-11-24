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
import com.hariobudiharjo.destiny.Activity.DetailDiscussionActivity
import com.hariobudiharjo.destiny.Activity.DetailFunStudyActivity
import com.hariobudiharjo.destiny.Model.discussionModel
import com.hariobudiharjo.destiny.Model.funStudyModel
import com.hariobudiharjo.destiny.R

class DiscussionAdapter(private val context: Context, private val items: List<discussionModel>) :
    RecyclerView.Adapter<DiscussionAdapter.ViewHolder>() {
    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        fun bindItems(data: discussionModel) {

            val title: TextView = itemView.findViewById(R.id.title)
            val sub: TextView = itemView.findViewById(R.id.sub)

            title.text = data.judul
            sub.text = data.deskripsi


            itemView.setOnClickListener {
                val intent = Intent(it.context, DetailDiscussionActivity::class.java)
                intent.putExtra("name", data.judul)
                startActivity(it.context, intent, null)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiscussionAdapter.ViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.rv_list_discussion_item_row, parent, false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: DiscussionAdapter.ViewHolder, position: Int) {
        holder.bindItems(items[position])
    }
}