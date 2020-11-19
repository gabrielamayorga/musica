package com.example.spotififi.ui

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
import kotlinx.android.synthetic.main.musica_fragment.*

class MusicaFragment : Fragment() {

    private lateinit var viewModel: MusicaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.musica_fragment, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(MusicaViewModel::class.java)

        viewModel.musica.observe(viewLifecycleOwner, { musica ->

            txtNomeMusica.setText(musica.musica)
            txtArtista.setText(musica.artista)
            txtFoto.setText(musica.foto)

            view.findViewById<Button>(R.id.btnSalvar).setOnClickListener {
                var musica = Musica(
                    docId = musica.docId,
                    musica = txtNomeMusica.text.toString(),
                    artista = txtArtista.toString(),
                    foto = txtFoto.text.toString()
                )


                viewModel.repository.salvarMusica(musica)
                findNavController().navigateUp()
            }
        })
        return view
    }
}