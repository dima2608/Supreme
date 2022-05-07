package com.triare.supreme.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.triare.supreme.R
import com.triare.supreme.ui.dvo.NewsDvo

class MediaNewsAdapter(private val context: Context) :
    RecyclerView.Adapter<MediaNewsAdapter.MediaNewsHolder>() {

    private var items: List<NewsDvo> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MediaNewsHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_media_news, parent, false)
        return MediaNewsHolder(itemView)
    }

    override fun onBindViewHolder(holder: MediaNewsHolder, position: Int) {
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

    inner class MediaNewsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val title = itemView.findViewById<TextView>(R.id.title_media_news)
        private val subtitle = itemView.findViewById<TextView>(R.id.subtitle_media_news)
        private val img = itemView.findViewById<ImageView>(R.id.icon_media_news)

        fun bind(data: NewsDvo) {
            title.text = data.title
            subtitle.text = data.subtitle

            Glide.with(context)
                .load(data.imgLink)
                .centerInside()
                .into(img)
        }
    }


}