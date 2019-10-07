package com.estebanacevedo.a_maintenance.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MapaViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Muestra mapa con ubicación de los activos"
    }
    val text: LiveData<String> = _text
}