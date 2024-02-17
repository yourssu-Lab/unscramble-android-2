package com.ursssu.unscramble.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class GameStartViewModel : ViewModel() {

    val textFieldHelperLabelText : MutableStateFlow<String> = MutableStateFlow("")
    val GameStartWordText : MutableStateFlow<String> = MutableStateFlow("test")
    val GameStartTimerText : MutableStateFlow<String> = MutableStateFlow("5 : 31")

    private fun checkText(text: String): Boolean {
        if (text.isEmpty()) return false
        for (i in 0 until text.length) {
            if (!((text[i] in 'A'..'Z') || (text[i] in 'a'..'z'))) {
                return false
            }
        }
        return true
    }

    fun onBtnGameStartSubmit(text: String){
        if (checkText(text)) {

        } else {
            textFieldHelperLabelText.value = "영문 대 소문자만 사용가능합니다."
        }
    }
}