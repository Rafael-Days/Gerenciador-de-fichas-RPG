package com.example.latariarpg.view

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.latariarpg.R
import com.example.latariarpg.viewmodel.CharSheetViewModel

class CharSheetFragment : Fragment() {

    companion object {
        fun newInstance() = CharSheetFragment()
    }

    private val viewModel: CharSheetViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_char_sheet, container, false)
    }
}