package com.luismiguel.mock.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.luismiguel.mock.bean.DataClassMiRespuesta
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val iMain: IMain): ViewModel(){

    private val _result = MutableLiveData<Response<Any>>()
    val result: LiveData<Response<Any>>
        get() = _result

    fun mock(){
        viewModelScope.launch(Dispatchers.Main) {
            val result = iMain.llamada()
            _result.postValue(result)
            /*if(_result.value?.isSuccessful == true){
                Log.i("isSuccessful", "isSuccessful viewModel")
            }else{
                Log.i("isNotSuccessful", "isNotSuccessful viewModel")
            }*/
        }
    }
}