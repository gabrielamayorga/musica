package com.example.spotififi.ui

import android.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.navigation.findNavController
import com.example.spotififi.R
import com.example.spotififi.model.Musica

class MusicaAdapter(
    private val activity : FragmentActivity,
    private val viewModel: MusicaViewModel,
    private val musicas: List<Musica>
) : RecyclerView.Adapter<MusicaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicaViewHolder  {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_musica, parent, false)
        return MusicaViewHolder(view)
    }

    override fun onBindViewHolder(holder: MusicaViewHolder, position: Int) {
        val musica = musicas[position]
        holder.idMusica.text = musica.id.toString()
        holder.nomeMusica.text = musica.nome

        holder.itemView.setOnClickListener{view ->
            viewModel.musica.value = musica
            view.findNavController().navigate(R.id.action_listaMusicaFragment_to_musicaFragment)
        }

        holder.itemView.setOnLongClickListener{ view ->
          view?.let {
              AlertDialog.Builder(activity)
                  .setTitle("Leia")
                  .setMessage("Deseja excluir essa música?")
                  .setPositiveButton("Sim") { dialog, which ->
                      viewModel.excluirMusica(musica.id)
                  }
                  .setNegativeButton("Não", null)
                  .show()
          }
          true
        }

    }

    override fun getItemCount(): Int = musicas.size
}