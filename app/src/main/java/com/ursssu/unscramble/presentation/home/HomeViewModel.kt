package com.ursssu.unscramble.presentation.home

import androidx.lifecycle.ViewModel
import com.ursssu.unscramble.util.livedata.MutableSingleLiveData
import com.ursssu.unscramble.util.livedata.SingleLiveData

class HomeViewModel : ViewModel() {

    private val _event: MutableSingleLiveData<EventType> = MutableSingleLiveData()
    val event: SingleLiveData<EventType> = _event

    fun navigate() {
        _event.postValue(EventType.NAVIGATION)
    }

    enum class EventType {
        NAVIGATION
    }
}
