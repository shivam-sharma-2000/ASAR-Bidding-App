package com.example.asartask.adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.asartask.R
import com.example.asartask.model.Header
import com.example.asartask.model.Question
import com.example.asartask.screen.YesNoActivity
import com.squareup.picasso.Picasso


class HeaderAdapter(private val items: List<Header>?) : RecyclerView.Adapter<HeaderAdapter.HeaderViewHolder>() {

    class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.header_title)
        val subTitle: TextView = itemView.findViewById(R.id.header_subTitle)
        val subTitle2: TextView = itemView.findViewById(R.id.header_subTitle2)
        val image: ImageView = itemView.findViewById(R.id.header_image)

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): HeaderViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.header_layout, parent, false)
        return HeaderViewHolder(view)
    }

    override fun onBindViewHolder(holder: HeaderViewHolder, position: Int) {
        val item = items?.get(position)
        holder.title.text = item!!.headerTitle;
        holder.subTitle.text = item.headerSubtitle;
        holder.subTitle2.text = item.headerSubtitle2;

        Picasso.get()
            .load(item.headerImage)
            .placeholder(R.drawable.ic_launcher_foreground) // Optional: Show this placeholder while loading
            .error(R.drawable.ic_launcher_foreground) // Optional: Show this image if loading fails
            .into(holder.image)

        holder.itemView.setOnClickListener(View.OnClickListener {
            Toast.makeText(it.context, items!![position].headerTitle, Toast.LENGTH_SHORT).show()
        })

    }

    override fun getItemCount() = items!!.size
}
























