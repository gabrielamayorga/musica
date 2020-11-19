package com.example.spotififi.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
/*import com.example.spotififi.db.Banco*/
import com.example.spotififi.model.Musica
import com.example.spotififi.repository.MusicaRepository
import kotlinx.coroutines.launch

class MusicaViewModel(app : Application) : AndroidViewModel(app) {

    var musica = MutableLiveData<Musica>()
    var repository = MusicaRepository()
    var listademusicas = repository.listaMusicas


}