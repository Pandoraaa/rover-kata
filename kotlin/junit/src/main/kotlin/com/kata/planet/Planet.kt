package com.kata.planet

import com.kata.rover.Position
import kotlin.math.absoluteValue

data class Planet(
    val dimension: Dimension,
    val obstacles: List<Position> = emptyList()
) {
    companion object {
        fun mars(obstacles: List<Position> = emptyList()): Planet {
            return Planet(planetSize(4, 4), obstacles)
        }
    }

    fun isAnEdge(position: Position): Boolean {
        return dimension.height.div(2).absoluteValue == position.y.absoluteValue ||
                dimension.width.div(2).absoluteValue == position.x.absoluteValue
    }

    fun hasObstacleAt(position: Position): Boolean {
        return obstacles.contains(position)
    }
}
