package com.ursssu.unscramble.presentation.timer

import android.text.Editable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TimerViewModel : ViewModel() {

    private val minute = MutableLiveData<String>()
    private val second = MutableLiveData<String>()

    val isMinuteDisabled = MutableLiveData(true)
    val isSecondDisabled = MutableLiveData(true)

    val isButtonValid: MutableLiveData<Boolean> = MutableLiveData(false)

    fun checkButton() {
        isButtonValid.value = !(isMinuteDisabled.value == false && isSecondDisabled.value == false)
    }

    fun onMinuteChanged(s: Editable) {
        minute.value = s.toString()
        isMinuteDisabled.value = s.isNullOrEmpty()
    }

    fun onSecondChanged(s: Editable) {
        second.value = s.toString()
        isSecondDisabled.value = s.isNullOrEmpty()
    }
}
