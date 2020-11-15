package com.example.spotififi.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.spotififi.R
import com.example.spotififi.model.Musica
import kotlinx.android.synthetic.main.item_musica.view.*
import kotlinx.android.synthetic.main.musica_fragment.*

class MusicaFragment : Fragment() {

    private lateinit var viewModel: MusicaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.musica_fragment, container, false)
        viewModel = ViewModelProvider(this).get(MusicaViewModel::class.java)

        viewModel.musica.observe(viewLifecycleOwner, { musica ->

            txtNomeMusica.setText(musica.nome)
            txtArtista.setText(musica.artista)

            view.findViewById<Button>(R.id.btnSalvar).setOnClickListener {
                val nome = txtNomeMusica.text.toString()
                val artista = txtArtista.toString()

                viewModel.salvarMusica(Musica(id = musica.id, nome = nome, artista = artista))
                findNavController().navigateUp()
            }
        })
        return view
    }
}