package com.example.weather_app_final

import kotlinx.coroutines.flow.Flow

class CityRepository(private val cityDao: CityDao) {

    val allCities: Flow<List<City>> = cityDao.getAllCities()

    suspend fun insert(city: City) {
        cityDao.insertCity(city)
    }
}
