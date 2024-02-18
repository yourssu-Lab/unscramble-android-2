package com.ursssu.unscramble.presentation.timer

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ursssu.unscramble.R
import com.ursssu.unscramble.databinding.FragmentTimerBinding
import com.ursssu.unscramble.util.binding.BaseFragment

class TimerFragment : BaseFragment<FragmentTimerBinding>(R.layout.fragment_timer) {

    private val viewModel: TimerViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initDataBinding()
        initClickListener()
        observeTimerInput()
    }

    private fun initDataBinding() {
        binding.viewModel = viewModel
    }

    private fun initClickListener() {
        initTimerClickListener()
    }


    private fun initTimerClickListener() {
        binding.btnTimer.setOnClickListener {
            val bundle = bundleOf(
                "minute" to viewModel.minute.value,
                "second" to viewModel.second.value
            )
            findNavController().navigate(R.id.gameStartFragment, bundle)
        }
    }

    private fun observeTimerInput() {
        viewModel.isMinuteDisabled.observe(viewLifecycleOwner) { isDisabled ->
            binding.btnTimer.isDisabled = isDisabled
            viewModel.checkButton()
        }
        viewModel.isSecondDisabled.observe(viewLifecycleOwner) { isDisabled ->
            binding.btnTimer.isDisabled = isDisabled
            viewModel.checkButton()
        }
    }

}