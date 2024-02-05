package com.ursssu.unscramble.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TimerViewModel : ViewModel() {
    val buttonText: MutableLiveData<String> = MutableLiveData("START")

}