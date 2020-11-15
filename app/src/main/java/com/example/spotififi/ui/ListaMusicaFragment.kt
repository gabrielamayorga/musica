package com.example.spotififi.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.spotififi.R
import com.example.spotififi.model.Musica

import com.google.android.material.floatingactionbutton.FloatingActionButton



class ListaMusicaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.lista_musicas, container, false)
        var recycler = view.findViewById<RecyclerView>(R.id.list)
        var viewModel = ViewModelProvider(requireActivity()).get(MusicaViewModel::class.java)

        viewModel.listaMusicas.observe(requireActivity(), { musicas ->
            with(recycler){
                adapter = MusicaAdapter(requireActivity(), viewModel, musicas)
            }
        })

        view.findViewById<FloatingActionButton>(R.id.fab).setOnClickListener{
            viewModel.musica.value = Musica()
            findNavController().navigate(R.id.action_listaMusicaFragment_to_musicaFragment)
        }

        return view
    }
}