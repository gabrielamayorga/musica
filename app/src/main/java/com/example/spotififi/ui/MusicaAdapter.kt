package com.example.spotififi.ui

import android.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.example.spotififi.R
import com.example.spotififi.model.Musica
import com.google.firebase.storage.FirebaseStorage

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
        holder.nomeMusica.text = musica.musica
        holder.nomeArtista.text = musica.artista

        val storage = FirebaseStorage.getInstance()
        val storageReference = storage.getReference(musica.foto)
        storageReference.downloadUrl.addOnSuccessListener { imageURL ->
            Glide.with(activity)
                .load(imageURL)
                .into(holder.fotoArtista)
        }

        storageReference.downloadUrl.addOnFailureListener{
            Glide.with(activity)
                .load(R.drawable.artista_desconhecido)
                .into(holder.fotoArtista)
        }

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
                      viewModel.repository.excluirMusica(musica.docId)
                  }
                  .setNegativeButton("Não", null)
                  .show()
          }
          true
        }

    }

    override fun getItemCount(): Int = musicas.size
}