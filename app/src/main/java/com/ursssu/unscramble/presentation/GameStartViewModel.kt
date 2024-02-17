package com.ursssu.unscramble.presentation

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class GameStartViewModel : ViewModel() {

    val textFieldHelperLabelText: MutableStateFlow<String> = MutableStateFlow("")
    val GameStartWordText: MutableStateFlow<String> = MutableStateFlow("test")
    val GameStartTimerText: MutableStateFlow<String> = MutableStateFlow("5 : 31")

    private fun checkText(text: String): Boolean {
        val regex = Regex("[A-Za-z]+")
        if (text.isEmpty()) return false
        return regex.matches(text)
    }

    fun onBtnGameStartSubmit(text: String) {
        if (checkText(text)) {

        } else {
            textFieldHelperLabelText.value = "영문 대 소문자만 사용가능합니다."
        }
    }
}