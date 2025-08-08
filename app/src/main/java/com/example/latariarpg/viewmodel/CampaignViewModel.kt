package com.example.latariarpg.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.latariarpg.service.model.CampaignModel
import com.example.latariarpg.service.repository.CampaignRepository

class CampaignViewModel : ViewModel() {

    private val _campaign = MutableLiveData<List<CampaignModel>>()
    val campaign: LiveData<List<CampaignModel>> = _campaign

    private val repository = CampaignRepository()

    fun getAllCampaigns(){
        _campaign.value = repository.getAllCampaigns()
    }
}