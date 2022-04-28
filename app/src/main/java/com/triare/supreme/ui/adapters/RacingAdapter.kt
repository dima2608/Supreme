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
import com.triare.supreme.ui.dvo.RacingDvo

class RacingAdapter(private val context: Context) :
    RecyclerView.Adapter<RacingAdapter.RacingViewHolder>() {

    private var items: List<RacingDvo> = emptyList()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RacingAdapter.RacingViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_racing, parent, false)
        return RacingViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RacingAdapter.RacingViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun submitRacingList(contentList: List<RacingDvo>) {
        val oldList = items
        val diffResult: DiffUtil.DiffResult = DiffUtil.calculateDiff(
            RacingItemDiffCallback(
                oldList,
                contentList
            )
        )
        items = contentList
        diffResult.dispatchUpdatesTo(this)
    }

    class RacingItemDiffCallback(
        private val oldRaceList: List<RacingDvo>,
        private val newRaceList: List<RacingDvo>
    ) : DiffUtil.Callback() {
        override fun getOldListSize(): Int {
            return oldRaceList.size
        }

        override fun getNewListSize(): Int {
            return newRaceList.size
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {

            return (oldRaceList[oldItemPosition].circuitId == newRaceList[newItemPosition].circuitId)
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldRaceList[oldItemPosition].equals(newRaceList[newItemPosition])
        }
    }

    inner class RacingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val country = itemView.findViewById<TextView>(R.id.racing_country_name)
        private val date = itemView.findViewById<TextView>(R.id.racing_date)
        private val img = itemView.findViewById<ImageView>(R.id.racing_img)
        private val trackName = itemView.findViewById<TextView>(R.id.racing_circle_name)
        private val round = itemView.findViewById<TextView>(R.id.racing_round)
        private val laps = itemView.findViewById<TextView>(R.id.racing_laps)

        fun bind(data: RacingDvo) {

            country.text = data.country
            date.text = data.date
            trackName.text = data.circuitName
            round.text = data.round
            laps.text = data.laps

            Glide.with(context)
                .load(data.icon)
                .into(img)
        }
    }


}