package com.ursssu.unscramble.presentation

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.ursssu.unscramble.R
import com.ursssu.unscramble.databinding.FragmentGameStartBinding
import com.ursssu.unscramble.util.binding.BaseFragment
import com.yourssu.design.system.atom.BoxButton


class GameStartFragment : BaseFragment<FragmentGameStartBinding>(R.layout.fragment_game_start) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickListener()

        binding.textGameStartTimer.text = "5 : 31"

        binding.btnGameStartSubmit.text = "Submit"

        binding.btnGameStartSkip.text = "Skip"
        binding.btnGameStartSkip.type = BoxButton.LINE

        binding.textfieldGameStart.helperLabelText = ""

        binding.textGameStartWord.text = "test"

    }

    private fun initClickListener() {
        initGameStartClickListener()
    }

    private fun checkText(text: String): Boolean {
        if (text.isEmpty()) return false
        for (i in 0 until text.length) {
            if (!((text[i] in 'A'..'Z') || (text[i] in 'a'..'z'))) {
                return false
            }
        }
        return true
    }

    private fun initGameStartClickListener() {
        binding.btnGameStartSubmit.setOnClickListener {
            if (checkText(binding.textfieldGameStart.text.toString())) {
                findNavController().navigate(R.id.endFragment)
            } else {
                binding.textfieldGameStart.helperLabelText = "영문 대 소문자만 사용가능합니다."
            }
        }
    }

}