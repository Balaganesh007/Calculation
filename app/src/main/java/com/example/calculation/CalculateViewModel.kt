package com.example.calculation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalculateViewModel : ViewModel() {
    private val _add  = MutableLiveData<Int>()
    val add :LiveData<Int>
        get() = _add
    private val _sub  = MutableLiveData<Int>()
    val sub :LiveData<Int>
        get() = _sub
    private val _div  = MutableLiveData<Double>()
    val div :LiveData<Double>
        get() = _div
    private val _mult = MutableLiveData<Int>()
    val mult :LiveData<Int>
        get() = _mult


    fun addition(number01 : Int , number02 : Int){
            _add.value = number01+number02
    }
    fun subtraction(number01 : Int , number02 : Int){
            _sub.value = number01-number02
    }
    fun division(number01 : Int , number02 : Int){
            _div.value = number01.toDouble()/number02.toDouble()
    }
    fun multiplication(number01 : Int , number02 : Int){
            _mult.value = number01*number02
    }

}