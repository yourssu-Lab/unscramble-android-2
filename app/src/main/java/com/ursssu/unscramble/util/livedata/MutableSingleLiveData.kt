package com.ursssu.unscramble.util.livedata

class MutableSingleLiveData<T> : SingleLiveData<T> {

    constructor()

    constructor(value: T) {
        liveData.value = Event(value)
    }

    public override fun postValue(value: T) {
        super.postValue(value)
    }

    public override fun setValue(value: T) {
        super.setValue(value)
    }
}
