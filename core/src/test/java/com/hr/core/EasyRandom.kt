package com.hr.core

import org.jeasy.random.EasyRandom
import org.jeasy.random.EasyRandomParameters

val easyRandom = EasyRandom(
    EasyRandomParameters()
        .seed(System.currentTimeMillis())
        .collectionSizeRange(1, 10)
)

inline fun <reified T : Any> some(): T = easyRandom.nextObject(T::class.java)
inline fun <reified T : Any> someListOf(size: Int = 30) = 0.until(size).map { some<T>() }