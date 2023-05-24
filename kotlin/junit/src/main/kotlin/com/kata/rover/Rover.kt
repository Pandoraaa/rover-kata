package com.kata.rover

import com.kata.planet.Planet

data class Rover(
    val direction: Direction = Direction.NORTH,
    val position: Position = Position(0, 0),
    val planet: Planet = Planet.mars(),
    val message: String? = null
) {

    fun receivedCommand(command: Command): Rover {
        return Rover(rotate(command), move(command).position, planet, move(command).message)
    }

    fun receivedCommands(commands: List<Command>): Rover {
        return commands.fold(this, Rover::receivedCommand)
    }

    private fun move(command: Command): Rover {
        val modifier = when (command) {
            Command.FORWARDS -> 1
            Command.BACKWARDS -> -1
            else -> 0
        }
        val newPosition = when (direction) {
            Direction.NORTH -> Position(position.x, (position.y + 1 * modifier))
            Direction.SOUTH -> Position(position.x, (position.y - 1 * modifier))
            Direction.EAST -> Position((position.x + 1 * modifier), position.y)
            Direction.WEST -> Position((position.x - 1 * modifier), position.y)
        }

        val position = if (planet.isAnEdge(position)) {
            wrappedPosition()
        } else
            newPosition

        val message = checkForObstacleAt(position)

        return Rover(direction, position, planet, message)
    }

    private fun checkForObstacleAt(position: Position): String? {
        if (planet.hasObstacleAt(position)) {
            return "beep boop there is an obstacle at (${position.x},${position.y}), ignoring other commands"
        }
        return null
    }

    private fun wrappedPosition() =
        if (direction === Direction.NORTH || direction === Direction.SOUTH) {
            Position(position.x, position.y * -1)
        } else
            Position(position.x * -1, position.y)

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
