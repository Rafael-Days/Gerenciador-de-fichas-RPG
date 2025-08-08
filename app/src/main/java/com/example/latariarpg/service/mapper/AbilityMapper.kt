package com.example.latariarpg.service.mapper

import com.example.latariarpg.service.model.AbilityModel
import com.example.latariarpg.service.model.entity.AbilityEntity

class AbilityMapper {

    fun AbilityModel.toEntity(idFicha: Int): AbilityEntity {
        return AbilityEntity(
            idHabilidade = this.idHabilidade,
            nomeHabilidade = this.nomeHabilidade,
            descricaoHabilidade = this.descricaoHabilidade,
            levelHabilidade = this.levelHabilidade,
            idFicha = idFicha
        )
    }

    fun AbilityEntity.toModel(): AbilityModel {
        return AbilityModel(
            idHabilidade = this.idHabilidade,
            nomeHabilidade = this.nomeHabilidade,
            descricaoHabilidade = this.descricaoHabilidade,
            levelHabilidade = this.levelHabilidade
        )
    }

    fun List<AbilityModel>.toEntityList(idFicha: Int): List<AbilityEntity> {
        return this.map { it.toEntity(idFicha) }
    }

    fun List<AbilityEntity>.toModelList(): List<AbilityModel> {
        return this.map { it.toModel() }
    }

}