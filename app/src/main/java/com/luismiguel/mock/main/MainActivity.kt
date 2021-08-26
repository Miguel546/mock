package com.luismiguel.mock.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.google.gson.Gson
import com.luismiguel.mock.R
import com.luismiguel.mock.any.isAllNullInside
import com.luismiguel.mock.bean.DataClassMiRespuesta
import com.luismiguel.mock.bean.Result2
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.reflect.KClass
import kotlin.reflect.full.declaredMemberProperties

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val homeViewModel: MainViewModel by viewModels()
    val gson= Gson()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        homeViewModel.mock()
        homeViewModel.result.observe(this, Observer{result ->
            //System.out.println(result.body())
            if(result.isSuccessful){
                val dataClassMiRespuesta : DataClassMiRespuesta =
                gson.fromJson(gson.toJson(result.body()), DataClassMiRespuesta::class.java)

                if(dataClassMiRespuesta.isAllNullInside(dataClassMiRespuesta)){
                    Log.i("dataClassMiRespuesta", "$dataClassMiRespuesta")
                }


                val result2 : Result2 =
                    gson.fromJson(gson?.toJson(result.body()), Result2::class.java)
                if(result2.isAllNullInside(result2)){
                    Log.i("result2", "$result2")
                }
            }else{
                Log.i("isNotSuccessful", "isNotSuccessful")
            }

        })
    }



    fun Any.listProperties(){
        for(property in this::class.declaredMemberProperties){
            println("${property.name} ${property.returnType}")
        }
    }
}