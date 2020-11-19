package com.example.spotififi.repository

import androidx.lifecycle.MutableLiveData
import com.example.spotififi.model.Musica
import com.google.firebase.firestore.FirebaseFirestore

class MusicaRepository {

    var listaMusicas = MutableLiveData<MutableList<Musica>>()
    private val db = FirebaseFirestore.getInstance()

    init {
        db.collection("musicas")
            .get()
            .addOnCompleteListener{docs ->
                if(docs.isSuccessful){
                    var musicas = mutableListOf<Musica>()
                    docs.result?.forEach{ doc ->
                        val musica = doc.toObject(Musica::class.java)
                        if(musica != null){
                            musica.docId = doc.id
                            musicas.add(musica)
                        }
                    }
                    listaMusicas.value = musicas
                }else {
                    listaMusicas.value = mutableListOf()
                }
            }

        db.collection("musicas")
            .addSnapshotListener { snapshot, _ ->
                if(snapshot != null){
                    var musicas = mutableListOf<Musica>()
                    snapshot.documents.forEach{ doc ->
                        val musica = doc.toObject(Musica::class.java)
                        if(musica != null){
                            musica.docId = doc.id
                            musicas.add(musica)
                        }
                    }
                    listaMusicas.value = musicas
                }

            }
    }

    fun salvarMusica(musica: Musica) {
        if(musica.docId.isBlank()){
            var doc = db.collection("musicas").document()
            musica.docId = doc.id
            doc.set(musica)
        }else{
            db.collection("musicas")
                .document(musica.docId)
                .set(musica)
        }
    }

    fun excluirMusica(docId : String) {
        db.collection("musicas")
            .document(docId)
            .delete()
    }
}