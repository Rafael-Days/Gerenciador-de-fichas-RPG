package com.example.latariarpg.view

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.latariarpg.R
import com.example.latariarpg.databinding.FragmentCharSheetBinding
import com.example.latariarpg.databinding.FragmentSheetBinding
import com.example.latariarpg.service.constants.CampaignConstants
import com.example.latariarpg.view.adapter.SheetAdapter
import com.example.latariarpg.viewmodel.CharSheetViewModel
import com.example.latariarpg.viewmodel.SheetViewModel

class CharSheetFragment : Fragment() {

    private var _binding: FragmentCharSheetBinding? = null
    private val binding get() = _binding!!

    private val viewModel: CharSheetViewModel by viewModels()

    private var campaignId = 0
    private var sheetId = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCharSheetBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setObservers()

        campaignId = arguments?.getInt(CampaignConstants.KEY.CAMPAIGN_ID) ?: 0
        sheetId = arguments?.getInt(CampaignConstants.KEY.SHEET_ID) ?: 0
        viewModel.getSheet(campaignId, sheetId)

        return root
    }

    private fun setObservers(){
        viewModel.char_sheet.observe(viewLifecycleOwner){
            binding.textviewName.text = it.nome
            binding.edittextLevel.setText(it.level.toString())
            binding.textviewClass.text = it.classe
            binding.edittextProficiency.setText(it.proficiencia.toString())
            binding.edittextCa.setText(it.classeArmadura.toString())
            binding.edittextInitiative.setText(it.iniciativa.toString())
            binding.edittextCd.setText(it.classeDificuldade.toString())

            binding.edittextHpMax.setText(it.pvMax.toString())
            binding.edittextHpCurrent.setText(it.pvAtual.toString())

            binding.strength.setText(it.atributos.forca.toString())
            binding.dexterity.setText(it.atributos.destreza.toString())
            binding.constitution.setText(it.atributos.constituicao.toString())
            binding.intelligence.setText(it.atributos.inteligencia.toString())
            binding.wisdom.setText(it.atributos.sabedoria.toString())
            binding.charisma.setText(it.atributos.carisma.toString())
        }
    }

}