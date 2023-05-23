package com.kata.rover

import com.kata.planet.Planet

data class Rover(
    val direction: Direction = Direction.NORTH,
    val position: Position = Position(0, 0),
    val planet: Planet = Planet.mars()
) {
    fun receivedCommand(command: Command): Rover {
        return Rover(rotate(command), move(command))
    }

    fun receivedCommands(commands: List<Command>): Rover {
        return commands.fold(this, Rover::receivedCommand)
    }

    private fun move(command: Command): Position {
        val modifier = when (command) {
            Command.FORWARDS -> 1
            Command.BACKWARDS -> -1
            else -> 0
        }
        return when (direction) {
            Direction.NORTH -> Position(position.x, (position.y + 1 * modifier))
            Direction.SOUTH -> Position(position.x, (position.y - 1 * modifier))
            Direction.EAST -> Position((position.x + 1 * modifier), position.y)
            Direction.WEST -> Position((position.x - 1 * modifier), position.y)
        }
    }

    private fun rotate(command: Command): Direction {
        return when (command) {
            Command.RIGHT -> rotateClockWise()
            Command.LEFT -> rotateCounterClockWise()
            else -> doNotRotate()
        }
    }
    private fun rotateClockWise() = when (direction) {
        Direction.NORTH -> Direction.EAST
        Direction.SOUTH -> Direction.WEST
        Direction.EAST -> Direction.SOUTH
        Direction.WEST -> Direction.NORTH
    }

    private fun rotateCounterClockWise() = when (direction) {
        Direction.NORTH -> Direction.WEST
        Direction.SOUTH -> Direction.EAST
        Direction.EAST -> Direction.NORTH
        Direction.WEST -> Direction.SOUTH
    }

    private fun doNotRotate() = when (direction) {
        Direction.NORTH -> Direction.NORTH
        Direction.SOUTH -> Direction.SOUTH
        Direction.EAST -> Direction.EAST
        Direction.WEST -> Direction.WEST
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
    BACKWARDS,
    LEFT,
    RIGHT
}

enum class Rotate {

}
