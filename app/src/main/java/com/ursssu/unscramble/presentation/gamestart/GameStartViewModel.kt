package com.ursssu.unscramble.presentation.gamestart

import androidx.lifecycle.ViewModel
import com.ursssu.unscramble.util.livedata.MutableSingleLiveData
import com.ursssu.unscramble.util.livedata.SingleLiveData
import kotlinx.coroutines.flow.MutableStateFlow
import java.util.Random

class GameStartViewModel : ViewModel() {

    private val progress: MutableSingleLiveData<Int> = MutableSingleLiveData(1)
    private val score: MutableSingleLiveData<Int> = MutableSingleLiveData(0)

    val textFieldHelperLabelText: MutableStateFlow<String> = MutableStateFlow("")
    val gameStartWordText: MutableStateFlow<String> = MutableStateFlow("")
    val gameStartTimerText: MutableStateFlow<String> = MutableStateFlow("")
    val gameStartProgressText: MutableStateFlow<String> =
        MutableStateFlow(progress.value.toString() + "/10")
    val gameStartScoreText: MutableStateFlow<String> = MutableStateFlow(score.value.toString())

    private val _event: MutableSingleLiveData<EventType> = MutableSingleLiveData()
    val event: SingleLiveData<EventType> = _event

    private var wordState: String = ""

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

    private fun checkText(text: String): Boolean { //영 대소문자 검사
        val regex = Regex("[A-Za-z]+")
        return regex.matches(text) && !text.isEmpty()
    }

    fun onBtnGameStartSubmit(text: String) {
        if (checkText(text)) {
            progress.setValue(progress.value!!.plus(1))
            textFieldHelperLabelText.value = ""
            if (progress.value!! > 10) {
                _event.postValue(EventType.NAVIGATION)
            }
            if (text == wordState) {
                score.setValue(score.value!!.plus(10))
            }
        } else {
            textFieldHelperLabelText.value = "영문 대 소문자만 사용가능합니다."
        }
        gameStartProgressText.value = progress.value.toString() + "/10"
        gameStartScoreText.value = score.value.toString()
        wordRandomScramble(randomWord())
    }

    fun onBtnGameStartSkip() {
        progress.setValue(progress.value!!.plus(1))
        if (progress.value!! > 10) {
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

}