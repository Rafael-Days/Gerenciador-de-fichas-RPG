package com.example.latariarpg.service.model.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "abilities",
    foreignKeys = [
        ForeignKey(
            entity = SheetEntity::class,
            parentColumns = ["idFicha"],
            childColumns = ["idFicha"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class AbilityEntity(
    @PrimaryKey(autoGenerate = true) val idHabilidade: Int = 0,
    val nomeHabilidade: String,
    val descricaoHabilidade: String,
    val levelHabilidade: Int,
    val idFicha: Int // <- chave estrangeira
)