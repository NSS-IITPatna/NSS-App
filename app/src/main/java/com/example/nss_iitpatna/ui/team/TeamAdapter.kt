package com.example.nss_iitpatna.ui.team

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.nss_iitpatna.databinding.CardTeamBinding
import com.example.nss_iitpatna.network.Team

class TeamAdapter :
    ListAdapter<Team, TeamAdapter.TeamViewHolder>(DiffCallback) {

    class TeamViewHolder(private val binding: CardTeamBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(team: Team) {
            binding.team = team
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TeamViewHolder {
        return TeamViewHolder(
            CardTeamBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        val team = getItem(position)
        holder.bind(team)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Team>() {
        override fun areItemsTheSame(oldItem: Team, newItem: Team): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Team, newItem: Team): Boolean {
            return oldItem.name == newItem.name
        }
    }

}
