package com.ploddasha.cinemashiftapp

import android.app.Application
import com.ploddasha.cinemashiftapp.film.di.filmViewModel
import com.ploddasha.cinemashiftapp.main.di.mainModule
import com.ploddasha.cinemashiftapp.navigation.navigationModule
import com.ploddasha.cinemashiftapp.poster.di.filmPosterModule
import com.ploddasha.cinemashiftapp.schedule.di.scheduleViewModel
import com.ploddasha.cinemashiftapp.seatselection.di.seatSelectionViewModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class CinemaShiftApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(level = Level.DEBUG)
            androidContext(this@CinemaShiftApplication)
            modules(
                networkModule,
                navigationModule,
                mainModule,
                filmPosterModule,
                filmViewModel,
                scheduleViewModel,
                seatSelectionViewModule
            )
        }
    }
}