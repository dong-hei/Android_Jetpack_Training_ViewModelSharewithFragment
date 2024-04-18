package com.dk.viewmodelWithActivityAndFragment

import androidx.lifecycle.ViewModel

class MainVM : ViewModel() {

    var countVal = 0

    fun plus(){
        countVal++
    }

    fun minus(){
        countVal--
    }

    fun getCnt() : Int{
        return countVal
    }
}