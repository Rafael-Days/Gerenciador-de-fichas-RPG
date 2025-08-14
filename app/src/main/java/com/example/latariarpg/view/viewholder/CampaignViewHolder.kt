package com.example.latariarpg.view.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.latariarpg.databinding.ItemCampaignBinding
import com.example.latariarpg.service.model.CampaignModel
import com.example.latariarpg.view.listener.CampaignListener

class CampaignViewHolder(
    private val item: ItemCampaignBinding,
    private val listener: CampaignListener
) : RecyclerView.ViewHolder(item.root) {

    fun bind(campaign: CampaignModel) {
        item.textviewTitle.text = campaign.nomeCampanha
        item.textviewDescrition.text = campaign.descricaoCampanha

        item.layoutCampaignItem.setOnClickListener { listener.onClick(campaign.idCampanha) } // função anonima
    }
}

//campaign: CampaignModel