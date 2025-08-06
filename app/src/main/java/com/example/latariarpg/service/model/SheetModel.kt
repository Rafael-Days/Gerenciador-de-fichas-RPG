package com.example.latariarpg.service.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Sheet")
data class SheetModel(
    @PrimaryKey val idFicha: Int,
    val nome: String,
    val level: Int,
    val classe: String,
    val proficiencia: Int,
    val classeArmadura: Int, //CA
    val iniciativa: Int,
    val classeDificuldade: Int, //CD
    val pvMax: Int,
    val pvAtual: Int,
    // atributos
    @Embedded val atributos: AttributesModel,
    // skills
    @Embedded val habilidades: MutableList<AbilityModel> = mutableListOf()
)