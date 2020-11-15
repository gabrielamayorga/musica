package com.example.spotififi.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.spotififi.model.Musica

@Dao
interface MusicaDao {

    @Query("SELECT * FROM musicas")
    fun listarTodas() : LiveData<List<Musica>>

    @Insert
    suspend fun inserir(musica: Musica)

    @Update
    suspend fun atualizar(musica: Musica)

    @Query("DELETE FROM musicas WHERE id = (:id)")
    suspend fun apagar(id : Int)

    @Query("DELETE FROM musicas")
    suspend fun apagarTodos()
}