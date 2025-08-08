package com.example.latariarpg.service.model.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.latariarpg.service.model.AttributesModel

@Entity(tableName = "sheets")
data class SheetEntity(
    @PrimaryKey val idFicha: Int,
    val nome: String,
    val level: Int,
    val classe: String,
    val proficiencia: Int,
    val classeArmadura: Int, // CA
    val iniciativa: Int,
    val classeDificuldade: Int, // CD
    val pvMax: Int,
    val pvAtual: Int,
    @Embedded val atributos: AttributesModel
)