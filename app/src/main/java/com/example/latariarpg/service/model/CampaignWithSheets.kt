package com.example.latariarpg.service.model

import androidx.room.Embedded
import androidx.room.Relation
import com.example.latariarpg.service.model.entity.CampaignEntity
import com.example.latariarpg.service.model.entity.SheetEntity

data class CampaignWithSheets(
    @Embedded val campaign: CampaignEntity,
    @Relation(
        parentColumn = "idCampanha",
        entityColumn = "idCampanha"
    )
    val fichas: List<SheetEntity>
)