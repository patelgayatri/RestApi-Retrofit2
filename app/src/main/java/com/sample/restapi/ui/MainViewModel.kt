package com.sample.restapi.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
import com.sample.restapi.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MainRepository) : ViewModel() {

    val loader = MutableLiveData<Boolean>()
    
    val playlists = liveData {
        loader.postValue(true)
        emitSource(repository.getTvShow()
            .onEach {
                loader.postValue(false)
            }.asLiveData()
        )
    }
}