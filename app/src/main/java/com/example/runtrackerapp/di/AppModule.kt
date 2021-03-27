package com.example.runtrackerapp.di

import android.content.Context
import androidx.room.Room
import com.example.runtrackerapp.other.Constants.RUN_DATABASE_NAME
import com.example.runtrackerapp.roomDB.database.RunDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRunDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        RunDatabase::class.java,
        RUN_DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun providesRunDao(db: RunDatabase) = db.getRunDao()

}