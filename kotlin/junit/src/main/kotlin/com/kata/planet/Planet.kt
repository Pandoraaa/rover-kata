package com.kata.planet

import com.kata.rover.Position
import kotlin.math.absoluteValue

data class Planet(
    val dimension: Dimension
) {
    companion object {
        fun mars(): Planet {
            return Planet(planetSize(4,4))
        }
    }

    fun isAnEdge(position: Position): Boolean {
        return dimension.height.div(2).absoluteValue == position.y.absoluteValue ||
        dimension.width.div(2).absoluteValue == position.x.absoluteValue
    }
}
