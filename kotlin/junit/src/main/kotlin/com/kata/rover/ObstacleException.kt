package com.kata.rover

class ObstacleException(position: Position) : Exception() {
    override val message: String? = "beep boop there is an obstacle at (${position.x},${position.y}), ignoring other commands"
}