package com.example.spotififi.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.spotififi.db.Banco
import com.example.spotififi.model.Musica
import kotlinx.coroutines.launch

class MusicaViewModel(app : Application) : AndroidViewModel(app) {

    var musica = MutableLiveData<Musica>()
    val musicaDao = Banco.get(app).musicaDao()
    var listademusicas = musicaDao.listarTodas()

    fun salvarMusica(musica: Musica) = viewModelScope.launch {
        if(musica.id == 0){
            musicaDao.inserir(musica)
        }else{
            musicaDao.atualizar(musica)
        }
    }

    fun excluirMusica(id : Int) = viewModelScope.launch {
        musicaDao.apagar(id)
    }
}