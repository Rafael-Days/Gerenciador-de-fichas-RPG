package com.example.latariarpg.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.latariarpg.service.model.CampaignModel
import com.example.latariarpg.service.model.SheetModel
import com.example.latariarpg.service.repository.CampaignRepository

class SheetViewModel : ViewModel() {

    private val repository: CampaignRepository = CampaignRepository()

    private val _sheet = MutableLiveData<List<SheetModel>>()
    val sheet: LiveData<List<SheetModel>> = _sheet

    private val _campaign = MutableLiveData<CampaignModel>()
    val campaign: LiveData<CampaignModel> = _campaign

    fun getCampaignId(id: Int){
        _campaign.value = repository.getCampaignById(id)
    }

    fun getAllSheets(id: Int){
        _sheet.value = repository.getAllSheetsByCampaignId(id)
    }
}
//getAllSheetsByCampaignId