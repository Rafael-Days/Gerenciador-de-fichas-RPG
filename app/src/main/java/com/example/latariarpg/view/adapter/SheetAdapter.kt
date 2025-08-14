package com.example.latariarpg.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.latariarpg.databinding.ItemSheetListBinding
import com.example.latariarpg.service.model.SheetModel
import com.example.latariarpg.view.listener.SheetListener
import com.example.latariarpg.view.viewholder.SheetViewHolder

class SheetAdapter: RecyclerView.Adapter<SheetViewHolder>() {

    private var sheetList: List<SheetModel> = listOf()
    private lateinit var sheetListener: SheetListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SheetViewHolder {
        val view = ItemSheetListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SheetViewHolder(view, sheetListener)
    }

    override fun getItemCount(): Int {
        return sheetList.size
    }

    override fun onBindViewHolder(holder: SheetViewHolder, position: Int) {
        holder.bind(sheetList[position])
    }

    fun updateSheets(list: List<SheetModel>){
        sheetList = list
        notifyDataSetChanged()
    }

    fun attachListener(listener: SheetListener){
        sheetListener = listener
    }
}