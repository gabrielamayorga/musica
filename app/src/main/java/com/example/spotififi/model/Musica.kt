package com.example.spotififi.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "musicas")
class Musica (
    @PrimaryKey(autoGenerate = true)
   var id: Int,
   var nome : String,
   var artista : String
)
{
    constructor() : this (0, String(), String())

}