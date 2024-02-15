package com.ursssu.unscramble.presentation.timer

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.ursssu.unscramble.R
import com.ursssu.unscramble.databinding.FragmentTimerBinding
import com.ursssu.unscramble.util.binding.BaseFragment
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class TimerFragment : BaseFragment<FragmentTimerBinding>(R.layout.fragment_timer) {

    private val timerViewModel: TimerViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initDataBinding()
        initClickListener()
        observeTimerInput()

    }

    private fun initDataBinding() {
        binding.viewModel = timerViewModel
    }

    private fun initClickListener() {
        initTimerClickListener()
    }


    private fun initTimerClickListener() {
        binding.btnTimer.setOnClickListener {
            val bundle = bundleOf(
                "minute" to timerViewModel.minute.value,
                "second" to timerViewModel.second.value
            )
            findNavController().navigate(R.id.gameStartFragment, bundle)
        }
    }

    private fun observeTimerInput() {
        timerViewModel.isMinuteDisabled.flowWithLifecycle(lifecycle).onEach { isDisabled ->
            binding.btnTimer.isDisabled = isDisabled
            timerViewModel.checkButton()
        }.launchIn(lifecycleScope)
        timerViewModel.isSecondDisabled.flowWithLifecycle(lifecycle).onEach { isDisabled ->
            binding.btnTimer.isDisabled = isDisabled
            timerViewModel.checkButton()
        }.launchIn(lifecycleScope)
    }

}