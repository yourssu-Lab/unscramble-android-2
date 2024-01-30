package com.ursssu.unscramble.presentation

import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import com.ursssu.unscramble.R
import com.ursssu.unscramble.databinding.FragmentGameStartBinding
import com.ursssu.unscramble.util.binding.BaseFragment
import com.yourssu.design.system.atom.BoxButton
import com.yourssu.design.system.atom.EditText
import com.yourssu.design.system.compose.base.IconSize
import com.yourssu.design.system.foundation.Icon


class GameStartFragment : BaseFragment<FragmentGameStartBinding>(R.layout.fragment_game_start) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickListener()

        binding.btnGameStart.text = "Submit"

        binding.btnSkip.text = "Skip"
        binding.btnSkip.type = BoxButton.LINE

        binding.textfieldGameStart.helperLabelText = ""
    }

    private fun initClickListener(){
        initGameStartClickListener()
    }

    private fun checkText(text: String):Boolean{
        if(text.length == 0) return false
        for(i in 0..text.length-1){
            if(!((text[i] in 'A'..'Z') || (text[i] in 'a'..'z'))){
                return false
            }
        }
        return true
    }

    private fun initGameStartClickListener() {
        binding.btnGameStart.setOnClickListener {
            if(checkText(binding.textfieldGameStart.text.toString())) {
                findNavController().navigate(R.id.endFragment)
            }else{
                binding.textfieldGameStart.helperLabelText = "영문 대 소문자만 사용가능합니다."
            }
        }
    }
}