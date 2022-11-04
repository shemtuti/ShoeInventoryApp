package com.example.shoestoreinvetoryapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoestoreinvetoryapp.models.Shoe

class ShoeListViewModel : ViewModel() {

    private var _listOfShoes = MutableLiveData<MutableList<Shoe>>(mutableListOf())

    val listOfShoes: LiveData<MutableList<Shoe>>
        get() = _listOfShoes

    var shoe: Shoe ?= null

    init {
        initializeListOfShoes()
    }

    private fun initializeListOfShoes() {
        shoe = Shoe("", "", "", "")
    }


    fun addMyShoe() {
        shoe?.let { _listOfShoes.value!!.add(it.copy()) }
    }


}


