package com.example.bantest.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.bantest.R
import com.example.bantest.commons.Resource
import com.example.bantest.databinding.FragmentInformationCardBinding
import com.example.bantest.domain.models.InfoTDCModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InformationCardFragment : Fragment() {

    private val binding: FragmentInformationCardBinding by lazy {
        FragmentInformationCardBinding.inflate(layoutInflater)
    }
    private val viewModel: InforCardViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
        initObservers()
    }

    private fun initObservers() {
        initObserverGetInfoTDC()
        initObserverGetAllMovements()
    }

    private fun initObserverGetAllMovements() {
        viewModel.responseGetAllMovements.observe(viewLifecycleOwner){ movements ->
            movements.data.let {
                when(movements.status){
                    Resource.Status.SUCCESS -> {
                        movements.data?.let {

                        }
                    }
                    Resource.Status.ERROR -> {
                        Toast.makeText(requireContext(), movements.message, Toast.LENGTH_SHORT).show()
                    }
                    Resource.Status.LOADING -> {

                    }
                }
            }
        }
    }

    private fun initObserverGetInfoTDC() {
        viewModel.responseGetInfoTDC.observe(viewLifecycleOwner){ info ->
            info.data.let {
                when(info.status){
                    Resource.Status.SUCCESS -> {
                        info.data?.let {
                            initUiCreditCard(it.info)
                        }
                    }
                    Resource.Status.ERROR -> {
                        Toast.makeText(requireContext(), info.message, Toast.LENGTH_SHORT).show()
                    }
                    Resource.Status.LOADING -> {

                    }
                }
            }
        }
    }

    private fun initUiCreditCard(info : InfoTDCModel) {
        with(binding){

        }
    }

    private fun initUi() {
        with(binding){

        }
    }
}