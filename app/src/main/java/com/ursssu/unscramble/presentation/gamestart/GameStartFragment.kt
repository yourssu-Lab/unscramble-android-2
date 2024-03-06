package com.ursssu.unscramble.presentation.gamestart

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.ursssu.unscramble.R
import com.ursssu.unscramble.databinding.FragmentGameStartBinding
import com.ursssu.unscramble.presentation.timer.TimerFragmentArgs
import com.ursssu.unscramble.util.binding.BaseFragment

class GameStartFragment : BaseFragment<FragmentGameStartBinding>(R.layout.fragment_game_start) {

    private val gameStartViewModel: GameStartViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initClickListener()
        setTimer()
        initDataBinding()
        observeTimeOut()
        observeScoreEvent()

    }

    private fun initDataBinding() {
        binding.viewModel = gameStartViewModel

    }

    private fun initClickListener() {
        initGameStartClickListener()
        initSkipClickListener()
    }


    private fun initGameStartClickListener() {
        binding.btnGameStartSubmit.setOnClickListener {
            binding.viewModel?.onBtnGameStartSubmit(binding.textfieldGameStart.text.toString())
        }
    }

    private fun initSkipClickListener() {
        binding.btnGameStartSkip.setOnClickListener {
            binding.viewModel?.onBtnGameStartSkip()
        }
    }

    private fun observeScoreEvent() {
        gameStartViewModel.event.observe(viewLifecycleOwner) { eventType ->
            when (eventType) {
                GameStartViewModel.EventType.NAVIGATION -> findNavController().navigate(R.id.action_gameStartFragment_to_endFragment)
            }
        }
    }

    private fun setTimer() {
        val args: TimerFragmentArgs by navArgs()

        val minute = args.minute.toInt()
        val second = args.second.toInt()

        gameStartViewModel.startTimer(minute, second)
    }


    private fun observeTimeOut() {
        gameStartViewModel.navigateToEnd.observe(viewLifecycleOwner) {
            findNavController().navigate(R.id.endFragment)
        }
    }

}