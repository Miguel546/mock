package com.luismiguel.mock.any

import android.util.Log
import kotlin.reflect.full.declaredMemberProperties

fun Any.isAllNullInside(classs: Any): Boolean
{

    val numeroPropiedades = this.javaClass.kotlin.declaredMemberProperties.size
    //Log.i("numeroPropiedades", "${numeroPropiedades}")
    var numeroNulls = 0
    this.javaClass.kotlin.declaredMemberProperties.forEach {
        with(it) {
            //println("print $returnType: $name = ${it.get(classs)}")
            if(it.get(classs) == null){
                numeroNulls++
            }
        }
    }
    //Log.i("numeroNulls", "$numeroNulls")
    if(numeroPropiedades == numeroNulls){
        return false
    }else{
        return true
    }
}