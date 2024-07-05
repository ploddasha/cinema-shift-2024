package com.ploddasha.cinemashiftapp.schedule.data.network

import com.ploddasha.cinemashiftapp.schedule.data.model.ScheduleResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ScheduleApi {

    @GET("film/{filmId}/schedule")
    suspend fun getSchedule(@Path("filmId") filmId: String): ScheduleResponse

}