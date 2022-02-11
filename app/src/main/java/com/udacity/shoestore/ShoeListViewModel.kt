package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel: ViewModel() {
    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    private val _hasLoggedIn = MutableLiveData<Boolean>()
    val hasLoggedIn: LiveData<Boolean>
        get() = _hasLoggedIn

    init {
            _shoeList.value = mutableListOf()
            _hasLoggedIn.value = false
    }

    fun addNewShoe(shoe:Shoe){
      _shoeList.value?.add(shoe)
    }

    fun setLogIn()
    {
        _hasLoggedIn.value = true
    }

    fun resetLogIn()
    {
        _hasLoggedIn.value = false
    }

    fun resetList(){
        _shoeList.value = mutableListOf()
    }
}