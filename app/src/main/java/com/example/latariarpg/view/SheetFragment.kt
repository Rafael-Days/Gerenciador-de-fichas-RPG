package com.example.latariarpg.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.latariarpg.databinding.FragmentSheetBinding
import com.example.latariarpg.service.constants.CampaignConstants
import com.example.latariarpg.viewmodel.SheetViewModel

class SheetFragment : Fragment() {

    private var _binding: FragmentSheetBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SheetViewModel by viewModels()

    private var campaignId = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        b: Bundle?
    ): View {
        _binding = FragmentSheetBinding.inflate(inflater, container, false)
        val root: View = binding.root

        campaignId = arguments?.getInt(CampaignConstants.KEY.CAMPAIGN_ID) ?: 0
        viewModel//implementar get campaign id

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}