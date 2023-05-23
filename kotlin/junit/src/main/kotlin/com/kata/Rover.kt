package com.kata

data class Rover(
    val direction: Direction = Direction.NORTH,
    val position: Position = Position(0,0)
) {
    fun receivedCommand(command: Command): Rover {
        val newPosition = when (direction) {
            Direction.NORTH -> Position(0,1)
            Direction.SOUTH -> Position(0,-1)
            Direction.EAST -> Position(1,0)
            Direction.WEST -> Position(-1,0)
        }
        return Rover(direction, newPosition )
    }
}

enum class Direction {
    NORTH,
    SOUTH,
    EAST,
    WEST
}

enum class Command {
    FORWARDS,
    BACKWARDS
}
