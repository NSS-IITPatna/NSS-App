package com.example.nss_iitpatna.ui.gallery

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nss_iitpatna.network.Api
import com.example.nss_iitpatna.network.Gallery
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class GalleryViewModel : ViewModel() {

    private val _images = MutableLiveData<List<Gallery>>()
    val images: LiveData<List<Gallery>>
        get() = _images

    private val viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        getImages()
    }

    private fun getImages() {
        coroutineScope.launch {
            val getImagesDeferred = Api.networkService.getImagesAsync()
            try {
                val listResult = getImagesDeferred.await()
                if (listResult.isNotEmpty())
                    _images.value = listResult
            } catch (e: Exception) {
                Log.e("GalleryViewModel", e.message.toString())
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}