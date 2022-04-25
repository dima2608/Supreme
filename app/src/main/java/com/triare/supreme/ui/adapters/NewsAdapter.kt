package com.triare.supreme.ui.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.ktx.storage
import com.triare.supreme.R
import com.triare.supreme.ui.dvo.NewsDvo
import com.triare.supreme.ui.screens.news.NewsFragment
import kotlin.coroutines.coroutineContext

class NewsAdapter(private val context: Context): RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    private var items: List<NewsDvo> = emptyList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.NewsViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_news, parent, false)
        return NewsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NewsAdapter.NewsViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun submitNewsList(contentList: List<NewsDvo>) {
        val oldList = items
        val diffResult: DiffUtil.DiffResult = DiffUtil.calculateDiff(
            NewsItemDiffCallback(
                oldList,
                contentList
            )
        )
        items = contentList
        diffResult.dispatchUpdatesTo(this)
    }

    class NewsItemDiffCallback(
        private val oldNewsList: List<NewsDvo>,
        private val newNewsList: List<NewsDvo>
    ) : DiffUtil.Callback() {
        override fun getOldListSize(): Int {
            return oldNewsList.size
        }
        override fun getNewListSize(): Int {
            return newNewsList.size
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {

            return (oldNewsList[oldItemPosition].title == newNewsList[newItemPosition].title)
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldNewsList[oldItemPosition].equals(newNewsList[newItemPosition])
        }
    }

    inner class NewsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        private val title = itemView.findViewById<TextView>(R.id.news_title)
        private val date = itemView.findViewById<TextView>(R.id.news_date)
        private val img = itemView.findViewById<ImageView>(R.id.news_img)

        fun bind(data: NewsDvo) {
            title.text = data.title
            date.text = data.date

            Log.d("RefURL", data.imgLink)

            Glide.with(context)
                .load("gs://supreme-826a9.appspot.com/news/Imola_Lecler_22-04-2022.jpg")
                .into(img)
        }
    }


}