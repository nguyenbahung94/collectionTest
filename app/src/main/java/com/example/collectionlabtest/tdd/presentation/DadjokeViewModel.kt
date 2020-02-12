package com.example.collectionlabtest.tdd.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.collectionlabtest.R
import com.example.collectionlabtest.tdd.common.Stringloader

class DadjokeViewModel(stringLoader: Stringloader) : ViewModel() {
    private val _state = MutableLiveData<DadJokeState>()
    val state: LiveData<DadJokeState> = _state

    init {
        _state.postValue(DadJokeState(stringLoader.get(R.string.app_name)))
    }
}

