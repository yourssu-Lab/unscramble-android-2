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
    val gameStartTimerText: MutableStateFlow<String> = MutableStateFlow("")
    val gameStartProgressText: MutableStateFlow<String> =
        MutableStateFlow(progress.value.toString() + "/10")
    val gameStartScoreText: MutableStateFlow<String> = MutableStateFlow(score.value.toString())

    private val _event: MutableSingleLiveData<EventType> = MutableSingleLiveData()
    val event: SingleLiveData<EventType> = _event

    private fun checkText(text: String): Boolean {
        val regex = Regex("[A-Za-z]+")
        return regex.matches(text) && !text.isEmpty()
    }

    fun onBtnGameStartSubmit(text: String) {
        if (checkText(text)) {
            progress.setValue(progress.value!!.plus(1))
            if (progress.value!! > 10) {
                _event.postValue(EventType.NAVIGATION)
            }
            gameStartProgressText.value = progress.value.toString() + "/10"
            textFieldHelperLabelText.value = ""
            score.setValue(score.value!!.plus(10))
            gameStartScoreText.value = score.value.toString()
        } else {
            textFieldHelperLabelText.value = "영문 대 소문자만 사용가능합니다."
        }
    }

    fun onBtnGameStartSkip() {
        progress.setValue(progress.value!!.plus(1))
        if (progress.value!! > 10) {
            _event.postValue(EventType.NAVIGATION)
        }
        gameStartProgressText.value = progress.value.toString() + "/10"
        textFieldHelperLabelText.value = ""
    }

    enum class EventType {
        NAVIGATION
    }

}