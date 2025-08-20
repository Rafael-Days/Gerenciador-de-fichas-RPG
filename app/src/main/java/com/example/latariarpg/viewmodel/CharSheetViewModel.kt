package com.example.latariarpg.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.latariarpg.service.model.SheetModel
import com.example.latariarpg.service.repository.CampaignRepository

class CharSheetViewModel : ViewModel() {
    private val repository: CampaignRepository = CampaignRepository()

    private val _char_sheet = MutableLiveData<SheetModel>()
    val char_sheet: LiveData<SheetModel> = _char_sheet

    private val _sheets = MutableLiveData<List<SheetModel>>()
    val sheets: LiveData<List<SheetModel>> = _sheets

    fun getAllSheets(id: Int) {
        _sheets.value = repository.getAllSheetsByCampaignId(id)
    }

    fun getSheet(campaignId: Int, sheetId: Int) {
        _char_sheet.value = repository.getSheetByCampaignId(campaignId, sheetId)
    }
}