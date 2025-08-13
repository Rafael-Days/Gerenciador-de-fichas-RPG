package com.example.latariarpg.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.latariarpg.databinding.ItemCampaignBinding
import com.example.latariarpg.service.model.CampaignModel
import com.example.latariarpg.view.viewholder.CampaignViewHolder

class CampaignAdapter: RecyclerView.Adapter<CampaignViewHolder>() {

    private var campaignList: List<CampaignModel> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CampaignViewHolder {
        val view = ItemCampaignBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CampaignViewHolder(view)
    }

    override fun getItemCount(): Int {
        return campaignList.size
    }

    override fun onBindViewHolder(holder: CampaignViewHolder, position: Int) {
        holder.bind(campaignList[position])
    }

    fun updateCampaigns(list: List<CampaignModel>){
        campaignList = list
        notifyDataSetChanged()
    }
}