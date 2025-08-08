package com.example.latariarpg.view.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.latariarpg.databinding.ItemCampaignBinding
import com.example.latariarpg.service.model.CampaignModel

class CampaignViewHolder(private val item: ItemCampaignBinding): RecyclerView.ViewHolder(item.root) {

    fun bind(campaign: CampaignModel){
        item.textviewTitle.text = campaign.nomeCampanha
        item.textviewDescrition.text = campaign.descricaoCampanha
    }
}

//campaign: CampaignModel