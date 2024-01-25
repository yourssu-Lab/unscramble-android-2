package com.ursssu.unscramble.presentation

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.ursssu.unscramble.R
import com.ursssu.unscramble.databinding.FragmentGameStartBinding
import com.ursssu.unscramble.util.binding.BaseFragment

class GameStartFragment : BaseFragment<FragmentGameStartBinding>(R.layout.fragment_game_start) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initGameStartClickListener()

    }

    private fun initGameStartClickListener() {
        binding.btnGameStart.setOnClickListener {
            findNavController().navigate(R.id.endFragment)
        }
    }

}