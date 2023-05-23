package com.kata

class Rover(
    val direction: Direction = Direction.NORTH,
    val position: Position = Position(0,0)
)

enum class Direction {
    NORTH,
    SOUTH,
    EAST,
    WEST
}
