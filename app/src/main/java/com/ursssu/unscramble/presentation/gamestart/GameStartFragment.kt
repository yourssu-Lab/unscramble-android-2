package com.ursssu.unscramble.presentation.gamestart

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.ursssu.unscramble.R
import com.ursssu.unscramble.databinding.FragmentGameStartBinding
import com.ursssu.unscramble.util.binding.BaseFragment


class GameStartFragment : BaseFragment<FragmentGameStartBinding>(R.layout.fragment_game_start) {

    private val gameStartViewModel: GameStartViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickListener()
        initDataBinding()
        binding.textGameStartTimer.text = "5 : 31"

        binding.textGameStartWord.text = "test"

    }

    private fun initDataBinding() {
        binding.viewModel = gameStartViewModel
    }

    private fun initClickListener() {
        initGameStartClickListener()
    }

    private fun initGameStartClickListener() {
        binding.btnGameStartSubmit.setOnClickListener {
            binding.viewModel?.onBtnGameStartSubmit(binding.textfieldGameStart.text.toString())
        }
    }

}