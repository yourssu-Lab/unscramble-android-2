package com.ursssu.unscramble.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TimerViewModel : ViewModel() {
    val buttonText: MutableLiveData<String> = MutableLiveData("START")

    val fieldLabelTextString = MutableLiveData<String>("fieldLabelText")

    val isPositive: MutableLiveData<Boolean> = MutableLiveData(false)
    val isNegative: MutableLiveData<Boolean> = MutableLiveData(false)
    val isDisable: MutableLiveData<Boolean> = MutableLiveData(false)

}