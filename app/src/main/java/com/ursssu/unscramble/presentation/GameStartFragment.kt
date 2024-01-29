package com.ursssu.unscramble.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import com.ursssu.unscramble.R
import com.ursssu.unscramble.databinding.FragmentGameStartBinding
import com.ursssu.unscramble.util.binding.BaseFragment
import com.yourssu.design.system.atom.BoxButton
import com.yourssu.design.system.atom.EditText
import com.yourssu.design.system.foundation.Icon


class GameStartFragment : BaseFragment<FragmentGameStartBinding>(R.layout.fragment_game_start) {
    val submitType: MutableLiveData<Int> = MutableLiveData(BoxButton.TINTED)
    val skipType: MutableLiveData<Int> = MutableLiveData(BoxButton.LINE)
    val size: MutableLiveData<Int> = MutableLiveData(BoxButton.Large)
    val rounding: MutableLiveData<Int> = MutableLiveData(8)
    val isdisabled: MutableLiveData<Boolean> = MutableLiveData(false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickListener()

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
            if(checkText(binding.textfiledGameStart.text.toString())) {
                findNavController().navigate(R.id.endFragment)
            }else{
                //텍스트필드 헬퍼라벨텍스트 붉은 글씨 넣는 기능
            }
        }
    }
}