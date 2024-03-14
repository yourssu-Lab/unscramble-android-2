package com.ursssu.unscramble.presentation.gamestart

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ursssu.unscramble.R
import com.ursssu.unscramble.util.livedata.MutableSingleLiveData
import com.ursssu.unscramble.util.livedata.SingleLiveData
import java.util.Random
import java.util.Timer
import kotlin.concurrent.timer


class GameStartViewModel : ViewModel() {

    private val progress: MutableSingleLiveData<Int> = MutableSingleLiveData(1)

    private val score: MutableSingleLiveData<Int> = MutableSingleLiveData(0)

    val textFieldHelperLabelText: MutableLiveData<String> = MutableLiveData("")

    val gameStartWordText: MutableLiveData<String> = MutableLiveData("")

    val gameStartTimerText: MutableLiveData<String> = MutableLiveData("")

    val gameStartProgressText: MutableLiveData<String> =
        MutableLiveData(progress.value.toString() + "/10")

    val gameStartScoreText: MutableLiveData<String> = MutableLiveData(score.value.toString())

    private val _event: MutableSingleLiveData<EventType> = MutableSingleLiveData()
    val event: SingleLiveData<EventType> = _event

    private var wordState: String = ""

    private var time = 0

    private var timerTask: Timer? = null

    val timerText = MutableLiveData<String>()

    val navigateToEnd = MutableLiveData<Boolean>()

    val wordsList =
        listOf(
            "genuine",
            "holiday",
            "uniform",
            "harmony",
            "force",
            "bread",
            "normal",
            "expose",
            "tear",
            "fast"
        )

    init { //단어 제시하는 MutableStateFlow에 직접 함수를 넣어 리턴을 하려했으나 안돼서 생성자로 처리
        wordRandomScramble(randomWord())
    }

    private fun randomWord(): String { //무작위의 단어 리턴
        val random = Random()
        wordState = wordsList[random.nextInt(wordsList.size)]
        return wordState
    }

    private fun String.checkText(): Boolean = Regex("[A-Za-z]+").matches(this) && this.isNotEmpty()

    fun onBtnGameStartSubmit(text: String) {
        if (text.checkText()) {
            progress.value?.let { progress.setValue(it.plus(1)) }
            textFieldHelperLabelText.value = ""
            if ((progress.value ?: 0) > 10) {
                _event.postValue(EventType.NAVIGATION)
            }
            if (text == wordState) {
                score.value?.let { score.setValue(it.plus(10)) }
            }
        } else {
            textFieldHelperLabelText.value = R.string.game_start_helper_label.toString()
        }
        gameStartProgressText.value = progress.value.toString() + "/10"
        gameStartScoreText.value = score.value.toString()
        wordRandomScramble(randomWord())
    }

    fun onBtnGameStartSkip() {
        progress.value?.let { progress.setValue(it.plus(1)) }
        if ((progress.value ?: 0) > 10) {
            _event.postValue(EventType.NAVIGATION)
        }
        gameStartProgressText.value = progress.value.toString() + "/10"
        textFieldHelperLabelText.value = ""
        wordRandomScramble(randomWord())
    }

    private fun wordRandomScramble(_word: String) { //매개변수로 단어를 받고 단어를 섞은 후 리턴
        var word = _word
        var scramdbledWord = ""
        val random = Random()
        for (i in _word) {
            val tempIndex = random.nextInt(word.length)
            scramdbledWord += word[tempIndex]
            word = word.substring(0, tempIndex) + word.substring(tempIndex + 1)
        }
        gameStartWordText.value = scramdbledWord
    }

    enum class EventType {
        NAVIGATION
    }

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

                gameStartTimerText.postValue("$min : $sec")
            }
        }
    }
}