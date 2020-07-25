package com.example.nss_iitpatna.ui.events

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nss_iitpatna.network.Api
import com.example.nss_iitpatna.network.Event
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class EventsViewModel : ViewModel() {

    private val _events = MutableLiveData<List<Event>>()
    val events: LiveData<List<Event>>
        get() = _events

    private val viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        getEvents()
    }

    private fun getEvents() {
        coroutineScope.launch {
            val getEventsDeferred = Api.networkService.getEventsAsync()
            try {
                val listResult = getEventsDeferred.await()
                if (listResult.isNotEmpty()) {
                    _events.value = listResult
                }
            } catch (e: Exception) {
                Log.e("EventsViewModel", e.message.toString())
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}