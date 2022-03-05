package com.sample.restapi.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sample.restapi.data.models.TvShowItem
import com.sample.restapi.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MainRepository): ViewModel() {

    private var _tvShow = MutableLiveData<List<TvShowItem>>()
    val tvShow : LiveData<List<TvShowItem>> =_tvShow

    init {
        getAllTvShows()
    }

    private fun getAllTvShows() {
       viewModelScope.launch {
           repository.getTvShow().let {
               if(it.isSuccessful)
                   _tvShow.postValue(it.body())
               else
                   println("===="+it.code())
           }
       }
    }

}