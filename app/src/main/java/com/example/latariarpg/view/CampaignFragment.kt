package com.example.latariarpg.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.latariarpg.databinding.FragmentCampaignBinding
import com.example.latariarpg.service.model.CampaignModel
import com.example.latariarpg.view.adapter.CampaignAdapter
import com.example.latariarpg.viewmodel.CampaignViewModel

class CampaignFragment : Fragment() {

    private var _binding: FragmentCampaignBinding? = null
    private val binding get() = _binding!!

    private val viewModel: CampaignViewModel by viewModels()
    private val adapter: CampaignAdapter = CampaignAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val campaignViewModel =
            ViewModelProvider(this).get(CampaignViewModel::class.java)

        _binding = FragmentCampaignBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.recyclerviewCampaign.layoutManager = LinearLayoutManager(context)

        binding.recyclerviewCampaign.adapter = adapter

        viewModel.getAllCampaigns()

        setObservers()

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setObservers(){
        viewModel.campaign.observe(viewLifecycleOwner){
            adapter.updateCampaigns(it)
        }
    }
}