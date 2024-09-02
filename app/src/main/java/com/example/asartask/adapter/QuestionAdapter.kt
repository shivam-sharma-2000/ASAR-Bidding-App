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
import com.example.asartask.model.Question
import com.example.asartask.screen.YesNoActivity
import com.squareup.picasso.Picasso


class QuestionAdapter(private val items: List<Question>?) : RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder>() {

    class QuestionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val header: TextView = itemView.findViewById(R.id.question_header)
        val subTitle: TextView = itemView.findViewById(R.id.question_sub_title)
        val image: ImageView = itemView.findViewById(R.id.question_image)
        val yes: Button = itemView.findViewById(R.id.question_yes)
        val no: Button = itemView.findViewById(R.id.question_no)

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): QuestionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.question_layout, parent, false)
        return QuestionViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        val item = items?.get(position)
        holder.header.text = item!!.questionHeader;
        holder.subTitle.text = item.questionSubtitle;
        holder.yes.text = "Yes "+item.yesValue.toString();
        holder.no.text = "No "+item.noValue.toString();

        Picasso.get()
            .load(item.questionImage)
            .placeholder(R.drawable.ic_launcher_foreground) // Optional: Show this placeholder while loading
            .error(R.drawable.ic_launcher_foreground) // Optional: Show this image if loading fails
            .into(holder.image)

        holder.itemView.setOnClickListener(View.OnClickListener {
            val intent = Intent(it.context, YesNoActivity::class.java)
            intent.putExtra("question", items?.get(position))
            it.context.startActivity(intent)
        })

    }

    override fun getItemCount() = items!!.size
}
























