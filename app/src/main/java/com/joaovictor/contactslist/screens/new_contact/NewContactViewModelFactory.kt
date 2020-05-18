package com.joaovictor.contactslist.screens.new_contact

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class NewContactViewModelFactory(): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NewContactViewModel::class.java)) {
            return NewContactViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}