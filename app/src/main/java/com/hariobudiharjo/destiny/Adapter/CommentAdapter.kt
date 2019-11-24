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
import com.hariobudiharjo.destiny.Activity.DetailCoursesActivity
import com.hariobudiharjo.destiny.Activity.DetailFunStudyActivity
import com.hariobudiharjo.destiny.Model.commentModel
import com.hariobudiharjo.destiny.Model.coursesModel
import com.hariobudiharjo.destiny.Model.discussionModel
import com.hariobudiharjo.destiny.Model.funStudyModel
import com.hariobudiharjo.destiny.R

class CommentAdapter(private val context: Context, private val items: List<commentModel>) :
    RecyclerView.Adapter<CommentAdapter.ViewHolder>() {
    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        fun bindItems(data: commentModel) {

            val title: TextView = itemView.findViewById(R.id.title)
            val comment: TextView = itemView.findViewById(R.id.comment)
            val waktu: TextView = itemView.findViewById(R.id.waktu)

            title.text = data.nama
            comment.text = data.qoute
            waktu.text = data.deskripsi


//            image.setImageResource(data.imageint!!)

//            itemView.setOnClickListener {
//                val intent = Intent(it.context, DetailCoursesActivity::class.java)
//                intent.putExtra("name", data.nama)
//                startActivity(it.context, intent, null)
//            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentAdapter.ViewHolder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.rv_list_comment_item_row, parent, false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: CommentAdapter.ViewHolder, position: Int) {
        holder.bindItems(items[position])
    }
}