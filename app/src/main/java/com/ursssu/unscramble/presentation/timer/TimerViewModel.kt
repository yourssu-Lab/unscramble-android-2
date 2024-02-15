package com.ursssu.unscramble.presentation.timer

import android.text.Editable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class TimerViewModel : ViewModel() {

    val minute = MutableLiveData<Int>()
    val second = MutableLiveData<Int>()

    private val _isMinuteDisabled = MutableStateFlow(true)
    val isMinuteDisabled: StateFlow<Boolean> get() = _isMinuteDisabled

    private val _isSecondDisabled = MutableStateFlow(true)
    val isSecondDisabled: StateFlow<Boolean> get() = _isSecondDisabled
    val isButtonValid: MutableLiveData<Boolean> = MutableLiveData(false)

    fun checkButton() {
        isButtonValid.value = !(!_isMinuteDisabled.value && !_isSecondDisabled.value)
    }

    fun onMinuteChanged(s: Editable) {
        minute.value = s.toString().toInt()
        _isMinuteDisabled.value = s.isNullOrEmpty()
    }

    fun onSecondChanged(s: Editable) {
        second.value = s.toString().toInt()
        _isSecondDisabled.value = s.isNullOrEmpty()
    }
}
