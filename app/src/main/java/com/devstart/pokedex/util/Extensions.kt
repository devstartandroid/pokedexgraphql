package com.devstart.pokedex.util

fun Float.toSafeFloat(): Float = when {
    isNaN() -> 0f
    isInfinite() -> 100f
    else -> this
}