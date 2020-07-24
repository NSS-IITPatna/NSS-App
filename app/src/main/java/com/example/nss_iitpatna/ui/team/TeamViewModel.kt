package com.example.nss_iitpatna.ui.team

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nss_iitpatna.network.Api
import com.example.nss_iitpatna.network.Team
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch


class TeamViewModel : ViewModel() {

    private val _team = MutableLiveData<List<Team>>()
    val team: LiveData<List<Team>>
        get() = _team

    private val viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        getTeam()
    }

    private fun getTeam() {
        coroutineScope.launch {
            val getTeamDeferred = Api.networkService.getTeamAsync()
            try {
                val listResult = getTeamDeferred.await()
                if (listResult.isNotEmpty()) {
                    _team.value = listResult
                }
            } catch (e: Exception) {
                Log.e("TeamViewModel", e.message.toString())
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}