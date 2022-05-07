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
import com.triare.supreme.data.models.Result

class PodiumAdapter(private val context: Context) :
    RecyclerView.Adapter<PodiumAdapter.PodiumViewHolder>() {

    private var items: List<Result> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PodiumViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_podium, parent, false)
        return PodiumViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PodiumViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun submitPodiumList(contentList: List<Result>) {
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
        private val oldPodiumList: List<Result>,
        private val newPodiumList: List<Result>
    ) : DiffUtil.Callback() {
        override fun getOldListSize(): Int {
            return oldPodiumList.size
        }

        override fun getNewListSize(): Int {
            return newPodiumList.size
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {

            return (oldPodiumList[oldItemPosition].pos == newPodiumList[newItemPosition].pos)
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldPodiumList[oldItemPosition].equals(newPodiumList[newItemPosition])
        }
    }

    inner class PodiumViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val driver = itemView.findViewById<TextView>(R.id.overview_driver)
        private val time = itemView.findViewById<TextView>(R.id.overview_time)
        private val points = itemView.findViewById<TextView>(R.id.overview_pts)
        private val constructor = itemView.findViewById<TextView>(R.id.overview_constructor)
        private val img = itemView.findViewById<ImageView>(R.id.icon_overview)

        fun bind(data: Result) {

            driver.text = data.driver
            time.text = data.time
            points.text = data.points
            constructor.text = data.constructor

            Glide.with(context)
                .load(data.icon)
                .centerInside()
                .into(img)
        }
    }


}