package com.ursssu.unscramble.presentation.timer

import android.text.Editable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ursssu.unscramble.util.livedata.MutableSingleLiveData
import com.ursssu.unscramble.util.livedata.SingleLiveData

class TimerViewModel : ViewModel() {

    val minute = MutableLiveData("")
    val second = MutableLiveData("")

    private val _event: MutableSingleLiveData<EventType> = MutableSingleLiveData()
    val event: SingleLiveData<EventType> = _event

    fun onMinuteChanged(s: Editable) {
        minute.value = s.toString()
    }

    fun onSecondChanged(s: Editable) {
        second.value = s.toString()
    }

    fun navigate() {
        _event.postValue(EventType.NAVIGATION)
    }

    enum class EventType {
        NAVIGATION
    }
}
