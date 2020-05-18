package com.joaovictor.contactslist.screens.new_contact

import android.util.Log.i
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NewContactViewModel(): ViewModel() {
    private val _name = MutableLiveData<String>()
    private val _number = MutableLiveData<String>()

    val name: LiveData<String> get() = _name
    val number: LiveData<String> get() = _number


    init {
        _name.value = ""
        _number.value = ""
    }

    fun onSave(name: String, number: String) {
        _name.value = name
        _number.value = number
    }


    override fun onCleared() {
        super.onCleared()

        _number.value = ""
        _name.value = ""
    }

}