package com.example.nss_iitpatna.ui.team

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.nss_iitpatna.databinding.FragmentTeamBinding

class TeamFragment : Fragment() {

    private lateinit var teamViewModel: TeamViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentTeamBinding.inflate(inflater)
        teamViewModel = ViewModelProvider(this).get(TeamViewModel::class.java)

        val teamAdapter = TeamAdapter()
        binding.teamRecyclerView.adapter = teamAdapter
        teamViewModel.team.observe(viewLifecycleOwner, Observer {
            teamAdapter.submitList(it)
        })

        return binding.root
    }
}