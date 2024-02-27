package com.ursssu.unscramble.presentation.gamestart

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.Timer
import kotlin.concurrent.timer

class GameStartViewModel : ViewModel() {

    private var time = 0
    private var timerTask: Timer? = null

    val timerText = MutableLiveData<String>()
    val navigateToEnd = MutableLiveData<Boolean>()

    fun startTimer(minute: Int, second: Int) {
        val totalSeconds = minute * 60 + second

        timerTask = timer(period = 1000) {
            if (totalSeconds - time <= 0) {
                timerTask?.cancel()
                navigateToEnd.postValue(true)
            } else {
                time++

                val currSeconds = totalSeconds - time
                val min = currSeconds / 60
                val sec = currSeconds % 60

                timerText.postValue("$min : $sec")
            }
        }
    }
}