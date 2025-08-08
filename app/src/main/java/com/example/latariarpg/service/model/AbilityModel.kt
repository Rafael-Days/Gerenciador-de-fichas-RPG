package com.example.latariarpg.service.model

import com.example.latariarpg.service.model.entity.AbilityEntity

data class AbilityModel (
    val idHabilidade: Int,
    var nomeHabilidade: String,
    var descricaoHabilidade: String,
    var levelHabilidade: Int
)
