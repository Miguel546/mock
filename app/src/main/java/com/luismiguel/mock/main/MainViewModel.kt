package com.luismiguel.mock.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val iMain: IMain): ViewModel(){

    private val _result = MutableLiveData<Result<Any>>()
    val result: LiveData<Result<Any>>
        get() = _result

    fun mock(){
        viewModelScope.launch(Dispatchers.Main) {
            _result.postValue(iMain.llamada())
        }
    }
}