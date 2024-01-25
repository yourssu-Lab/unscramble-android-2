package com.ursssu.unscramble.presentation

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.ursssu.unscramble.R
import com.ursssu.unscramble.databinding.FragmentTimerBinding
import com.ursssu.unscramble.util.binding.BaseFragment

class TimerFragment : BaseFragment<FragmentTimerBinding>(R.layout.fragment_timer) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initTimerClickListener()

    }

    private fun initTimerClickListener() {
        binding.btnTimer.setOnClickListener {
            findNavController().navigate(R.id.gameStartFragment)
        }
    }

}