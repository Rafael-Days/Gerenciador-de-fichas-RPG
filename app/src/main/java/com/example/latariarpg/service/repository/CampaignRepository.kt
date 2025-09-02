package com.example.latariarpg.service.repository

import com.example.latariarpg.service.model.AbilityModel
import com.example.latariarpg.service.model.AttributesModel
import com.example.latariarpg.service.model.CampaignModel
import com.example.latariarpg.service.model.SheetModel

class CampaignRepository {

    private val campaigns = mutableListOf<CampaignModel>()

    init {
        campaigns.addAll(getInitialCampaigns())
    }

    private fun getInitialCampaigns(): List<CampaignModel> {
        // Atributos de exemplo
        val atributosMock = AttributesModel(
            forca = 14,
            destreza = 12,
            constituicao = 13,
            inteligencia = 10,
            sabedoria = 30,
            carisma = 1
        )

        // Habilidades de exemplo
        val habilidadesMock = listOf(
            AbilityModel(
                idHabilidade = 1,
                nomeHabilidade = "Fúria",
                descricaoHabilidade = "Dobra o dano por 2 turnos",
                levelHabilidade = 2
            ),
            AbilityModel(
                idHabilidade = 2,
                nomeHabilidade = "Grito de Guerra",
                descricaoHabilidade = "Inspira aliados próximos",
                levelHabilidade = 1
            )
        )

        // Ficha 1
        val ficha1 = SheetModel(
            idFicha = 1,
            nome = "Thorin Escudodeferro",
            level = 4,
            classe = "Guerreiro",
            proficiencia = 2,
            classeArmadura = 18,
            iniciativa = 1,
            classeDificuldade = 10,
            pvMax = 40,
            pvAtual = 40,
            atributos = atributosMock,
            habilidades = habilidadesMock
        )

        // Ficha 2
        val ficha2 = SheetModel(
            idFicha = 2,
            nome = "Elrion Sombrassol",
            level = 3,
            classe = "Mago",
            proficiencia = 2,
            classeArmadura = 13,
            iniciativa = 2,
            classeDificuldade = 14,
            pvMax = 25,
            pvAtual = 22,
            atributos = atributosMock,
            habilidades = listOf()
        )

        return listOf(
            CampaignModel(
                idCampanha = 1,
                nomeCampanha = "RPG dos Humildes",
                descricaoCampanha = "Campanha da busca do livro Nibilico",
                fichas = listOf(ficha1, ficha2)
            ),
            CampaignModel(
                idCampanha = 2,
                nomeCampanha = "Mar dos Larápios",
                descricaoCampanha = "Pirataria, roubos e canções",
                fichas = listOf(ficha2)
            )
        )
    }

    fun getAllCampaigns(): List<CampaignModel> {
        return campaigns
    }

    fun getCampaignById(id: Int): CampaignModel? {
        return campaigns.find { it.idCampanha == id }
    }

    fun getAllSheetsByCampaignId(id: Int): List<SheetModel>{
        return getCampaignById(id)?.fichas ?: emptyList()
    }

    fun getSheetByCampaignId(campaignId: Int, sheetId: Int): SheetModel? {
        return getAllSheetsByCampaignId(campaignId)
            .find { it.idFicha == sheetId }
    }

    fun deleteCampaign(id: Int): Boolean {
        return campaigns.removeIf { it.idCampanha == id }
    }
}