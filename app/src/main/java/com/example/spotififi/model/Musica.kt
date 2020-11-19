package com.example.spotififi.model

import androidx.room.PrimaryKey

class Musica (
   var docId: String,
   var musica : String,
   var artista : String,
   var foto : String
)
{
    constructor() : this (String(), String(), String(), String())

}