package com.kata.planet

data class Dimension(
    val height: Int,
    val width: Int
)

fun planetSize(height: Int, width: Int): Dimension {
    return Dimension(height, width)
}
