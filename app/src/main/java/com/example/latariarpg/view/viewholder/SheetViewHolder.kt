package com.example.latariarpg.view.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.latariarpg.databinding.ItemSheetListBinding
import com.example.latariarpg.service.model.SheetModel
import com.example.latariarpg.view.listener.SheetListener

class SheetViewHolder(private val item: ItemSheetListBinding, private val listener: SheetListener) :
    RecyclerView.ViewHolder(item.root) {

    fun bind(sheet: SheetModel) {
        item.textviewNameChar.text = sheet.nome
        item.textviewLevelChar.text = "${sheet.level}"
        item.textviewClassChar.text = sheet.classe
        item.textviewHp.text = "${sheet.pvMax} / ${sheet.pvAtual}"

        // Criar um evento que leva ao char sheet
        item.layoutSheetItem.setOnClickListener { listener.onClick(sheet.idFicha) }
    }
}