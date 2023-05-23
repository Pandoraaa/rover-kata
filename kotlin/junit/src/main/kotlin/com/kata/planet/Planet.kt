package com.kata.planet

data class Planet(
    val dimension: Dimension
) {
    companion object {
        fun mars(): Planet {
            return Planet(planetSize4x4())
        }
    }
}

fun planetSize4x4(): Dimension {
    return Dimension(4, 4)
}

