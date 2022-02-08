package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel: ViewModel() {
    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    init {
            _shoeList.value = mutableListOf()
    }

    fun addNewShoe(shoe:Shoe){
      _shoeList.value?.add(shoe)
    }

    fun resetList(){
        _shoeList.value = mutableListOf()
    }
}