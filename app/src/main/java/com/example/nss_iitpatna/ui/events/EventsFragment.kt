package com.example.nss_iitpatna.ui.events

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.nss_iitpatna.databinding.FragmentEventsBinding

class EventsFragment : Fragment() {

    private lateinit var eventsViewModel: EventsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentEventsBinding.inflate(inflater)
        eventsViewModel = ViewModelProvider(this).get(EventsViewModel::class.java)

        val eventAdapter = EventAdapter()
        binding.eventsRecyclerView.adapter = eventAdapter
        eventsViewModel.events.observe(viewLifecycleOwner, Observer {
            eventAdapter.submitList(it)
        })

        return binding.root
    }
}