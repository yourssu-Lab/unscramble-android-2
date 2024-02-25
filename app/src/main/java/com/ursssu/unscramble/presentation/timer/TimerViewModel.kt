package com.ursssu.unscramble.presentation.timer

import android.text.Editable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ursssu.unscramble.util.livedata.MutableSingleLiveData
import com.ursssu.unscramble.util.livedata.SingleLiveData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class TimerViewModel : ViewModel() {

    val minute = MutableLiveData<String>()
    val second = MutableLiveData<String>()

    private val _isMinuteDisabled: MutableStateFlow<Boolean> = MutableStateFlow(true)
    val isMinuteDisabled: StateFlow<Boolean> = _isMinuteDisabled.asStateFlow()

    private val _isSecondDisabled : MutableStateFlow<Boolean> = MutableStateFlow(true)
    val isSecondDisabled : StateFlow<Boolean> = _isSecondDisabled.asStateFlow()

    val isButtonValid: MutableLiveData<Boolean> = MutableLiveData(false)

    private val _event: MutableSingleLiveData<EventType> = MutableSingleLiveData()
    val event: SingleLiveData<EventType> = _event

    fun checkButton() {
        isButtonValid.value = !(!_isMinuteDisabled.value && !_isSecondDisabled.value)
    }

    fun onMinuteChanged(s: Editable) {
        minute.value = s.toString()
        _isMinuteDisabled.value = s.isEmpty()
    }

    fun onSecondChanged(s: Editable) {
        second.value = s.toString()
        _isSecondDisabled.value = s.isEmpty()
    }

    fun navigate() {
        _event.postValue(EventType.NAVIGATION)
    }

    enum class EventType {
        NAVIGATION
    }

}
