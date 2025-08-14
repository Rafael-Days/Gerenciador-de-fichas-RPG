package com.example.latariarpg.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.latariarpg.databinding.FragmentCampaignBinding
import com.example.latariarpg.view.adapter.CampaignAdapter
import com.example.latariarpg.view.listener.CampaignListener
import com.example.latariarpg.viewmodel.CampaignViewModel
import com.example.latariarpg.R
import com.example.latariarpg.service.constants.CampaignConstants

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
        _binding = FragmentCampaignBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.recyclerviewCampaign.layoutManager = LinearLayoutManager(context)
        binding.recyclerviewCampaign.adapter = adapter

        attachListener()

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

    private fun attachListener(){
        adapter.attachListener(object : CampaignListener{
            override fun onClick(id: Int) {

                val bundle = Bundle()
                bundle.putInt(CampaignConstants.KEY.CAMPAIGN_ID, id)

                findNavController().navigate(R.id.nav_sheet, bundle)
            }

        })
    }
}