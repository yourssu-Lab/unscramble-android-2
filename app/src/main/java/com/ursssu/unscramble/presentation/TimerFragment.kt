package com.ursssu.unscramble.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ursssu.unscramble.R
import com.ursssu.unscramble.databinding.FragmentTimerBinding
import com.ursssu.unscramble.util.binding.BaseFragment
import java.util.Timer

class TimerFragment : BaseFragment<FragmentTimerBinding>(R.layout.fragment_timer) {

    private val timerViewModel :TimerViewModel by  viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = timerViewModel
        binding.lifecycleOwner = viewLifecycleOwner

        initClickListener()

    }

    private fun initClickListener(){
        initTimerClickListener()
    }


    private fun initTimerClickListener() {
        binding.btnTimer.setOnClickListener {
            findNavController().navigate(R.id.gameStartFragment)
        }
    }

}