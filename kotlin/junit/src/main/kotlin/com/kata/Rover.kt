package com.kata

data class Rover(
    val direction: Direction = Direction.NORTH,
    val position: Position = Position(0,0)
) {
    fun receivedCommand(command: Command): Rover {
        return Rover(direction, moveForwards())
    }

    private fun moveForwards(): Position {
        return when (direction) {
            Direction.NORTH -> Position(0, position.y + 1)
            Direction.SOUTH -> Position(0, position.y - 1)
            Direction.EAST -> Position(position.x + 1, 0)
            Direction.WEST -> Position(position.x - 1, 0)
        }
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
