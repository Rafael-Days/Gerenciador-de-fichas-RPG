package com.example.latariarpg.service.model

data class CampaignModel (

    val idCampanha: Int,
    val nomeCampanha: String,
    val descricaoCampanha: String,
    val fichas: List<SheetModel>
)

//Caso o nome das colunas tenha algum problema, usar anotação ColumnInfo