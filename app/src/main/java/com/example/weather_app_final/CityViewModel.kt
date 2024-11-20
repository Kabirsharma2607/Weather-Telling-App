package com.example.weather_app_final

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class CityViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: CityRepository
    val allCities: LiveData<List<City>>

    init {
        val cityDao = CityDatabase.getDatabase(application).cityDao()
        repository = CityRepository(cityDao)
        allCities = repository.allCities.asLiveData()
    }

    fun insert(city: City) = viewModelScope.launch {
        repository.insert(city)
    }
}
