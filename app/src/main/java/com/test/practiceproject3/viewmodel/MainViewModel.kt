package com.test.practiceproject3.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val textFieldState  = MutableLiveData("")

    fun onTextChanged(newText : String){
        textFieldState.value = newText
    }
}