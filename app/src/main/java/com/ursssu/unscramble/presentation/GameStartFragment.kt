package com.ursssu.unscramble.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.ursssu.unscramble.R
import com.ursssu.unscramble.databinding.FragmentGameStartBinding
import com.ursssu.unscramble.databinding.FragmentTimerBinding
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