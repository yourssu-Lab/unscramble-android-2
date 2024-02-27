package com.ursssu.unscramble.presentation.timer

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ursssu.unscramble.R
import com.ursssu.unscramble.databinding.FragmentTimerBinding
import com.ursssu.unscramble.presentation.timer.TimerViewModel.EventType
import com.ursssu.unscramble.util.binding.BaseFragment

class TimerFragment : BaseFragment<FragmentTimerBinding>(R.layout.fragment_timer) {

    private val timerViewModel: TimerViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initDataBinding()
        observeEvent()
    }

    private fun initDataBinding() {
        binding.viewModel = timerViewModel
    }

    private fun observeEvent() {
        timerViewModel.event.observe(viewLifecycleOwner) { eventType ->
            when (eventType) {
                EventType.NAVIGATION -> sendDataToGameStart()
            }
        }
    }

    private fun sendDataToGameStart() {
        val minute = timerViewModel.minute.value
        val second = timerViewModel.second.value
        val action = TimerFragmentDirections.actionTimerFragmentToGameStartFragment(
            minute.orEmpty(),
            second.orEmpty()
        )
        findNavController().navigate(action)
    }

}