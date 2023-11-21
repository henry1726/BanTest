package com.example.bantest.ui

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bantest.R
import com.example.bantest.commons.Resource
import com.example.bantest.databinding.FragmentInformationCardBinding
import com.example.bantest.domain.models.InfoTDCModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.Locale
import kotlin.random.Random

@AndroidEntryPoint
class InformationCardFragment : Fragment() {

    private val binding: FragmentInformationCardBinding by lazy {
        FragmentInformationCardBinding.inflate(layoutInflater)
    }
    private val viewModel: InforCardViewModel by viewModels()
    private var countDownTimer: CountDownTimer? = null
    private lateinit var adapter: MovementsCardAdapter

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
                        movements.data?.let { response ->
                            response.listMovements?.let { list ->
                                adapter = MovementsCardAdapter(list, requireContext())
                                binding.rvMovements.adapter = adapter
                            }
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
            val list = info.cardName.split("-")
            tvFirstDigits.text = list[0]
            tvSecondDigits.text = list[1]
            tvThirdDigits.text = list[2]
            tvFourthDigits.text = list[3]
            tvDataCardHolder.text = info.cardHolder
            tvDataExpDate.text = info.expectationDate
            tvDataCvv.text = info.cvv

        }
    }

    private fun initUi() {
        with(binding){
            btnGenerateCvv.setOnClickListener {
                btnGenerateCvv.text = getString(R.string.title_cvv)
                binding.countdown.isVisible = true
                initCountDownTimer()
            }

            rvMovements.layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun initCountDownTimer(){
        countDownTimer = object : CountDownTimer(300000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                binding.countdown.text = formatMillisSeconds(millisUntilFinished)
            }

            override fun onFinish() {
                binding.btnGenerateCvv.text = getString(R.string.title_generate_cvv)
                binding.countdown.isVisible = false
                binding.tvDataCvv.text = generateCVV().toString()
            }
        }
        countDownTimer?.start()
    }

    private fun formatMillisSeconds(milliseconds: Long): String {
        val seconds = milliseconds / 1000
        val days = seconds / (24 * 3600)
        val hours = (seconds % (24 * 3600)) / 3600
        val minutes = ((seconds % (24 * 3600)) % 3600) / 60
        val remainingSeconds = ((seconds % (24 * 3600)) % 3600) % 60
        return String.format("%02d min:%02d sec", minutes, remainingSeconds)
    }

    private fun generateCVV(): Int{
        return Random.nextInt(100, 1000)
    }
}