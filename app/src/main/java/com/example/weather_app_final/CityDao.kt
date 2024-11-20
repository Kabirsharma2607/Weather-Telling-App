package com.example.weather_app_final

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CityDao {
    @Insert
    suspend fun insertCity(city: City)

    @Query("SELECT * FROM city_table ORDER BY id DESC")
    fun getAllCities(): Flow<List<City>>
}
