package com.ziadsyahrul.newsapp

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_item.view.*
import org.w3c.dom.Text

class NewsAdapter(val context: Context, val listNews: List<Model>): RecyclerView.Adapter<NewsAdapter.MyViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_item, parent, false))

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        holder.bindItem(listNews[position])

        var data = listNews[position]
        holder.bindItem(data, position)

        holder.itemView.setOnClickListener() { this.itemCallBack.onItemClick(listNews[position]) }
    }

    override fun getItemCount() = listNews.size

    private lateinit var itemCallBack: ItemCallBack

    fun setOnItemClickCallback(onItemClickCallback: ItemCallBack) {
        this.itemCallBack = onItemClickCallback
    }

    interface ItemCallBack{
        fun onItemClick(data: Model)
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {

        var news: Model? = null
        var position_news: Int = 0

        fun bindItem(model: Model, pos: Int) {
            itemView.txt_title.text = model!!.title
            itemView.txt_description.text = model!!.desc
            itemView.img_news.setImageResource(model!!.photo)

            this.news = model
            this.position_news = pos
        }

    }
}