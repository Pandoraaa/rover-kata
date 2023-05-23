package com.kata

data class Rover(
    val direction: Direction = Direction.NORTH,
    val position: Position = Position(0,0)
) {
    fun receivedCommand(command: Command): Rover {
        return Rover(direction, move(command))
    }

    private fun move(command: Command): Position {
        val modifier = when (command) {
            Command.FORWARDS -> 1
            Command.BACKWARDS -> -1
        }
        return when (direction) {
            Direction.NORTH -> Position(0, (position.y + 1 * modifier))
            Direction.SOUTH -> Position(0, (position.y - 1 * modifier))
            Direction.EAST -> Position((position.x + 1 * modifier), 0)
            Direction.WEST -> Position((position.x - 1 * modifier), 0)
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
