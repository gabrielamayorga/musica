package com.example.spotififi.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.spotififi.model.Musica

@Database(entities = [Musica::class], version = 1, exportSchema = false)
abstract class Banco : RoomDatabase(){

    abstract fun musicaDao() : MusicaDao

    companion object{
        @Volatile
        private var INSTANCE : Banco? = null
        fun get(context : Context) : Banco{
        var instance = INSTANCE
            if(instance == null){
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    Banco::class.java,
                    "banco.db"
                ).build()
            }
            return instance!!
        }
    }
}