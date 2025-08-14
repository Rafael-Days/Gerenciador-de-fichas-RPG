package com.example.latariarpg.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.latariarpg.R
import com.example.latariarpg.databinding.FragmentSheetBinding
import com.example.latariarpg.service.constants.CampaignConstants
import com.example.latariarpg.view.adapter.SheetAdapter
import com.example.latariarpg.view.listener.CampaignListener
import com.example.latariarpg.view.listener.SheetListener
import com.example.latariarpg.viewmodel.SheetViewModel

class SheetFragment : Fragment() {

    private var _binding: FragmentSheetBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SheetViewModel by viewModels()
    private val adapter: SheetAdapter = SheetAdapter()

    private var campaignId = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        b: Bundle?
    ): View {
        _binding = FragmentSheetBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.recyclerviewSheet.layoutManager = LinearLayoutManager(context)
        binding.recyclerviewSheet.adapter = adapter

        setObservers()

        attachListener()

        viewModel.getAllSheets(id)

        campaignId = arguments?.getInt(CampaignConstants.KEY.CAMPAIGN_ID) ?: 0
        viewModel.getCampaignId(campaignId)

        setObservers()

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setObservers(){
        viewModel.campaign.observe(viewLifecycleOwner){
            binding.textviewSheets.text = it.nomeCampanha
            adapter.updateSheets(it.fichas)
        }
    }

    private fun attachListener(){
        adapter.attachListener(object : SheetListener {
            override fun onClick(id: Int) {

                val bundle = Bundle()
                bundle.putInt(CampaignConstants.KEY.SHEET_ID, id)
                // verificar proque ele não está levando ao char sheet
                findNavController().navigate(R.id.nav_char_sheet, bundle)
            }

        })
    }
}