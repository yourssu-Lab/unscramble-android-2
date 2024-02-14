package com.ursssu.unscramble.util.livedata

class MutableSingleLiveData<T> : SingleLiveData<T> {

    constructor()

    constructor(value: T) {
        liveData.value = Event(value)
    }

    fun setValue(value: T) {
        liveData.value = Event(value)
    }

    fun postValue(value: T) {
        liveData.postValue(Event(value))
    }

}
