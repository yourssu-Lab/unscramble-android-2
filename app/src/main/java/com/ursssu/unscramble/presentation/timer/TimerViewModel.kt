package com.ursssu.unscramble.presentation.timer

import android.text.Editable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ursssu.unscramble.util.livedata.MutableSingleLiveData
import com.ursssu.unscramble.util.livedata.SingleLiveData

class TimerViewModel : ViewModel() {

    val minute = MutableLiveData<String>()
    val second = MutableLiveData<String>()

    val isMinuteDisabled = MutableLiveData(true)
    val isSecondDisabled = MutableLiveData(true)

    val isButtonValid: MutableLiveData<Boolean> = MutableLiveData(false)

    private val _event: MutableSingleLiveData<EventType> = MutableSingleLiveData()
    val event: SingleLiveData<EventType> = _event

    fun checkButton() {
        isButtonValid.value = !(isMinuteDisabled.value == false && isSecondDisabled.value == false)
    }

    fun onMinuteChanged(s: Editable) {
        minute.value = s.toString()
        isMinuteDisabled.value = s.isEmpty()
    }

    fun onSecondChanged(s: Editable) {
        second.value = s.toString()
        isSecondDisabled.value = s.isEmpty()
    }

    fun navigate() {
        _event.postValue(EventType.NAVIGATION)
    }

    enum class EventType {
        NAVIGATION
    }

}
