package com.example.spotififi.ui

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.spotififi.R

class MusicaViewHolder (view: View) : RecyclerView.ViewHolder(view) {

    val nomeMusica: TextView = view.findViewById(R.id.texto_musica)
    val nomeArtista: TextView = view.findViewById(R.id.texto_artista)
    val fotoArtista: ImageView = view.findViewById(R.id.imgFoto)

    override fun toString(): String {
        return super.toString() + " '" + nomeMusica.text + "'"
    }
}