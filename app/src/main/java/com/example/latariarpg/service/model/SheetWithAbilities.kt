package com.example.latariarpg.service.model

import androidx.room.Embedded
import androidx.room.Relation
import com.example.latariarpg.service.model.entity.AbilityEntity
import com.example.latariarpg.service.model.entity.SheetEntity

data class SheetWithAbilities(
    @Embedded val ficha: SheetEntity,
    @Relation(
        parentColumn = "idFicha",
        entityColumn = "idFicha"
    )
    val habilidades: List<AbilityEntity>
)

//como as models não conseguem usar room pois tem variaveis com list, essa classe relaciona elas com suas entitys