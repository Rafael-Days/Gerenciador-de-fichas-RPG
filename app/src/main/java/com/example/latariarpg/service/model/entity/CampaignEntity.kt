package com.example.latariarpg.service.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "campaigns")
data class CampaignEntity(
    @PrimaryKey val idCampanha: Int,
    val nomeCampanha: String,
    val descricaoCampanha: String
)