package com.ursssu.unscramble.presentation.gamestart

import androidx.lifecycle.ViewModel
import com.ursssu.unscramble.util.livedata.MutableSingleLiveData
import com.ursssu.unscramble.util.livedata.SingleLiveData
import kotlinx.coroutines.flow.MutableStateFlow

class GameStartViewModel : ViewModel() {

    private val progress: MutableSingleLiveData<Int> = MutableSingleLiveData(1)
    private val score: MutableSingleLiveData<Int> = MutableSingleLiveData(0)

    val textFieldHelperLabelText: MutableStateFlow<String> = MutableStateFlow("")
    val gameStartWordText: MutableStateFlow<String> = MutableStateFlow("test")
    val gameStartTimerText: MutableStateFlow<String> = MutableStateFlow("5 : 31")
    val gameStartProgressText: MutableStateFlow<String> =
        MutableStateFlow(progress.value.toString() + "/10")
    val gameStartScoreText: MutableStateFlow<String> = MutableStateFlow(score.value.toString())


    private fun checkText(text: String): Boolean {
        val regex = Regex("[A-Za-z]+")
        return regex.matches(text) && !text.isEmpty()
    }

    fun onBtnGameStartSubmit(text: String) {
        if (checkText(text)) {

        } else {
            textFieldHelperLabelText.value = "영문 대 소문자만 사용가능합니다."
        }
    }
}