package com.example.spotififi.ui

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.spotififi.R

class MusicaViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    val idMusica: TextView = view.findViewById(R.id.id_musica)
    val nomeMusica: TextView = view.findViewById(R.id.nome_musica)

    override fun toString(): String {
        return super.toString() + " '" + nomeMusica.text + "'"
    }
}