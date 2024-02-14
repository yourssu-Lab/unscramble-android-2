package com.ursssu.unscramble.util.livedata

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData

abstract class SingleLiveData<T> {

    protected val liveData = MutableLiveData<Event<T>>()

    val value get() = liveData.value?.content

    fun observe(owner: LifecycleOwner, onResult: (T) -> Unit) {
        liveData.observe(owner) { it.getContentIfNotHandled()?.let(onResult) }
    }

    fun observePeek(owner: LifecycleOwner, onResult: (T) -> Unit) {
        liveData.observe(owner) { onResult(it.content) }
    }

}
