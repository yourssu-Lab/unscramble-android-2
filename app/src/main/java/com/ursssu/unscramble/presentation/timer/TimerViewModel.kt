package com.ursssu.unscramble.presentation.timer

import android.text.Editable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TimerViewModel : ViewModel() {

    val minute = MutableLiveData<Int>()
    val second = MutableLiveData<Int>()

    val isMinuteDisabled = MutableLiveData(true)
    val isSecondDisabled = MutableLiveData(true)

    val isButtonValid: MutableLiveData<Boolean> = MutableLiveData(false)

    fun checkButton() {
        isButtonValid.value = !(isMinuteDisabled.value == false && isSecondDisabled.value == false)
    }

    fun onMinuteChanged(s: Editable) {
        minute.value = s.toString().toInt()
        isMinuteDisabled.value = s.isNullOrEmpty()
    }

    fun onSecondChanged(s: Editable) {
        second.value = s.toString().toInt()
        isSecondDisabled.value = s.isNullOrEmpty()
    }
}
