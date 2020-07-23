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

    private val _label = MutableLiveData<String>()
    val label: LiveData<String>
        get() = _label

    private val viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        getImages("")
    }

    fun getImages(label: String) {
        _label.value = label
        coroutineScope.launch {
            val getImagesDeferred = Api.networkService.getImagesAsync()
            try {
                val listResult = getImagesDeferred.await()
                if (listResult.isNotEmpty()) {
                    if (label != "") {
                        val newList = emptyList<Gallery>().toMutableList()
                        for (i in listResult) {
                            if (i.label == label)
                                newList += i
                            _images.value = newList
                        }
                    } else
                        _images.value = listResult
                }
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