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
import com.triare.supreme.ui.dvo.StandingsDvo

class StandingsAdapter(private val context: Context) :
    RecyclerView.Adapter<StandingsAdapter.StandingsViewHolder>() {

    private var items: List<StandingsDvo> = emptyList()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): StandingsAdapter.StandingsViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_standings, parent, false)
        return StandingsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: StandingsViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun submitRacingList(contentList: List<StandingsDvo>) {
        val oldList = items
        val diffResult: DiffUtil.DiffResult = DiffUtil.calculateDiff(
            StandingsItemDiffCallback(
                oldList,
                contentList
            )
        )
        items = contentList
        diffResult.dispatchUpdatesTo(this)
    }

    class StandingsItemDiffCallback(
        private val oldStandingsList: List<StandingsDvo>,
        private val newStandingsList: List<StandingsDvo>
    ) : DiffUtil.Callback() {
        override fun getOldListSize(): Int {
            return oldStandingsList.size
        }

        override fun getNewListSize(): Int {
            return newStandingsList.size
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {

            return (oldStandingsList[oldItemPosition].permanentNumber == newStandingsList[newItemPosition].permanentNumber)
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldStandingsList[oldItemPosition].equals(newStandingsList[newItemPosition])
        }
    }

    inner class StandingsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val permanentNum = itemView.findViewById<TextView>(R.id.standings_driver_number)
        private val name = itemView.findViewById<TextView>(R.id.standings_driver_name)
        private val icon = itemView.findViewById<ImageView>(R.id.standings_team_img)
        private val surname = itemView.findViewById<TextView>(R.id.standings_driver_surname)

        fun bind(data: StandingsDvo) {

            permanentNum.text = data.permanentNumber
            name.text = data.driverName
            surname.text = data.driverFamilyName

            Glide.with(context)
                .load(data.icon)
                .into(icon)
        }
    }
}