package com.ursssu.unscramble.presentation.gamestart

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.ursssu.unscramble.R
import com.ursssu.unscramble.databinding.FragmentGameStartBinding
import com.ursssu.unscramble.util.binding.BaseFragment


class GameStartFragment : BaseFragment<FragmentGameStartBinding>(R.layout.fragment_game_start) {

    private val gameStartViewModel: GameStartViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickListener()
        initDataBinding()
        observeScoreEvent()
    }

    private fun initDataBinding() {
        binding.viewModel = gameStartViewModel
    }

    private fun initClickListener() {
        initSubmitClickListener()
        initSkipClickListener()
    }

    private fun initSubmitClickListener() {
        binding.btnGameStartSubmit.setOnClickListener {
            gameStartViewModel?.onBtnGameStartSubmit(binding.textfieldGameStart.text.toString())
        }
    }

    private fun initSkipClickListener() {
        binding.btnGameStartSkip.setOnClickListener {
            gameStartViewModel?.onBtnGameStartSkip()
        }
    }

    private fun observeScoreEvent() { //진행상황이 문제 10개를 넘어갈 시에 네비게이션
        gameStartViewModel.event.observe(viewLifecycleOwner) { eventType ->
            when (eventType) {
                GameStartViewModel.EventType.NAVIGATION -> findNavController().navigate(R.id.action_gameStartFragment_to_endFragment)
            }
        }
    }

}