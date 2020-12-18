package com.dzul.appbusonquejas.ui.home

import android.content.Intent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dzul.appbusonquejas.vista_general

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Bienvenido Usuario"
    }
    val text: LiveData<String> = _text




}