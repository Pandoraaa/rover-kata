package com.kata

import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*

class RoverTest {

    @Test
    fun aDefaultRoverShouldFaceNorth() {
        val defaultRover = Rover()
        assertEquals(defaultRover.direction, Direction.NORTH)
    }

    @Test
    fun aDefaultRoverShouldBeAtPosition00() {
        val defaultRover = Rover()
        assertEquals(defaultRover.position, Position(0,0))
    }

    @Test
    fun aRoverFacingNorthShouldMove1PositionNorthWhenMovingForwards() {
        val aRover = Rover(direction = Direction.NORTH)
        val movedRover = aRover.receivedCommand(Command.FORWARDS)
        assertEquals(movedRover.position, Position(0,1))
    }

    @Test
    fun aRoverFacingSouthShouldMove1PositionSouthWhenMovingForwards() {
        val aRover = Rover(direction = Direction.SOUTH)
        val movedRover = aRover.receivedCommand(Command.FORWARDS)
        assertEquals(movedRover.position, Position(0,-1))
    }

    @Test
    fun aRoverFacingEastShouldMove1PositionEastWhenMovingForwards() {
        val aRover = Rover(direction = Direction.EAST)
        val movedRover = aRover.receivedCommand(Command.FORWARDS)
        assertEquals(movedRover.position, Position(1,0))
    }

    @Test
    fun aRoverFacingWestShouldMove1PositionWestWhenMovingForwards() {
        val aRover = Rover(direction = Direction.WEST)
        val movedRover = aRover.receivedCommand(Command.FORWARDS)
        assertEquals(movedRover.position, Position(-1,0))
    }

    @Test
    fun aRoverFacingNorthShouldMove2PositionsNorthWhenMovingForwardsTwice() {
        val aRover = Rover(direction = Direction.NORTH)
        val movedRover = aRover
            .receivedCommand(Command.FORWARDS)
            .receivedCommand(Command.FORWARDS)
        assertEquals(movedRover.position, Position(0,2))
    }

    @Test
    fun aRoverFacingSouthShouldMove2PositionsSouthWhenMovingForwardsTwice() {
        val aRover = Rover(direction = Direction.SOUTH)
        val movedRover = aRover
            .receivedCommand(Command.FORWARDS)
            .receivedCommand(Command.FORWARDS)
        assertEquals(movedRover.position, Position(0,-2))
    }

    @Test
    fun aRoverFacingEastShouldMove2PositionsEastWhenMovingForwardsTwice() {
        val aRover = Rover(direction = Direction.EAST)
        val movedRover = aRover
            .receivedCommand(Command.FORWARDS)
            .receivedCommand(Command.FORWARDS)
        assertEquals(movedRover.position, Position(2,0))
    }

    @Test
    fun aRoverFacingWestShouldMove2PositionsWestWhenMovingForwardsTwice() {
        val aRover = Rover(direction = Direction.WEST)
        val movedRover = aRover
            .receivedCommand(Command.FORWARDS)
            .receivedCommand(Command.FORWARDS)
        assertEquals(movedRover.position, Position(-2,0))
    }

    @Test
    fun aRoverFacingNorthShouldMove1PositionSouthWhenMovingBackwards() {
        val aRover = Rover(direction = Direction.NORTH)
        val movedRover = aRover.receivedCommand(Command.BACKWARDS)
        assertEquals(movedRover.position, Position(0,-1))
    }

    @Test
    fun aRoverFacingSouthShouldMove1PositionNorthWhenMovingBackwards() {
        val aRover = Rover(direction = Direction.SOUTH)
        val movedRover = aRover.receivedCommand(Command.BACKWARDS)
        assertEquals(movedRover.position, Position(0,1))
    }

    @Test
    fun aRoverFacingEastShouldMove1PositionWestWhenMovingBackwards() {
        val aRover = Rover(direction = Direction.EAST)
        val movedRover = aRover.receivedCommand(Command.BACKWARDS)
        assertEquals(movedRover.position, Position(-1,0))
    }

    @Test
    fun aRoverFacingWestShouldMove1PositionEastWhenMovingBackwards() {
        val aRover = Rover(direction = Direction.WEST)
        val movedRover = aRover.receivedCommand(Command.BACKWARDS)
        assertEquals(movedRover.position, Position(1,0))
    }

    @Test
    fun aRoverFacingNorthShouldMove2PositionsSouthWhenMovingBackwardsTwice() {
        val aRover = Rover(direction = Direction.NORTH)
        val movedRover = aRover
            .receivedCommand(Command.BACKWARDS)
            .receivedCommand(Command.BACKWARDS)
        assertEquals(movedRover.position, Position(0,-2))
    }

    @Test
    fun aRoverFacingSouthShouldMove2PositionsNorthWhenMovingBackwardsTwice() {
        val aRover = Rover(direction = Direction.SOUTH)
        val movedRover = aRover
            .receivedCommand(Command.BACKWARDS)
            .receivedCommand(Command.BACKWARDS)
        assertEquals(movedRover.position, Position(0,2))
    }

    @Test
    fun aRoverFacingEastShouldMove2PositionsWestWhenMovingBackwardsTwice() {
        val aRover = Rover(direction = Direction.EAST)
        val movedRover = aRover
            .receivedCommand(Command.BACKWARDS)
            .receivedCommand(Command.BACKWARDS)
        assertEquals(movedRover.position, Position(-2,0))
    }

    @Test
    fun aRoverFacingWestShouldMove2PositionsEastWhenMovingBackwardsTwice() {
        val aRover = Rover(direction = Direction.WEST)
        val movedRover = aRover
            .receivedCommand(Command.BACKWARDS)
            .receivedCommand(Command.BACKWARDS)
        assertEquals(movedRover.position, Position(2,0))
    }

    @Test
    fun aRoverFacingNorthShouldFaceEastWhenRotatingRight() {
        val aRover = Rover(direction = Direction.NORTH)
        val movedRover = aRover.receivedCommand(Command.RIGHT)
        assertEquals(movedRover.direction, Direction.EAST)
    }

    @Test
    fun aRoverFacingSouthShouldFaceWestWhenRotatingRight() {
        val aRover = Rover(direction = Direction.SOUTH)
        val movedRover = aRover.receivedCommand(Command.RIGHT)
        assertEquals(movedRover.direction, Direction.WEST)
    }

    @Test
    fun aRoverFacingEastShouldFaceSouthWhenRotatingRight() {
        val aRover = Rover(direction = Direction.EAST)
        val movedRover = aRover.receivedCommand(Command.RIGHT)
        assertEquals(movedRover.direction, Direction.SOUTH)
    }

    @Test
    fun aRoverFacingWestShouldFaceNorthWhenRotatingRight() {
        val aRover = Rover(direction = Direction.WEST)
        val movedRover = aRover.receivedCommand(Command.RIGHT)
        assertEquals(movedRover.direction, Direction.NORTH)
    }

    @Test
    fun aRoverFacingNorthShouldFaceWestWhenRotatingLeft() {
        val aRover = Rover(direction = Direction.NORTH)
        val movedRover = aRover.receivedCommand(Command.LEFT)
        assertEquals(movedRover.direction, Direction.WEST)
    }

    @Test
    fun aRoverFacingSouthShouldFaceEastWhenRotatingLeft() {
        val aRover = Rover(direction = Direction.SOUTH)
        val movedRover = aRover.receivedCommand(Command.LEFT)
        assertEquals(movedRover.direction, Direction.EAST)
    }

    @Test
    fun aRoverFacingEastShouldFaceNorthWhenRotatingLeft() {
        val aRover = Rover(direction = Direction.EAST)
        val movedRover = aRover.receivedCommand(Command.LEFT)
        assertEquals(movedRover.direction, Direction.NORTH)
    }

    @Test
    fun aRoverFacingWestShouldFaceSouthWhenRotatingLeft() {
        val aRover = Rover(direction = Direction.WEST)
        val movedRover = aRover.receivedCommand(Command.LEFT)
        assertEquals(movedRover.direction, Direction.SOUTH)
    }

    @Test
    fun aRoverFacingNorthShouldFaceSouthWhenRotatingRightTwice() {
        val aRover = Rover(direction = Direction.NORTH)
        val movedRover = aRover
            .receivedCommand(Command.RIGHT)
            .receivedCommand(Command.RIGHT)
        assertEquals(movedRover.direction, Direction.SOUTH)
    }

    @Test
    fun aRoverFacingNorthShouldFaceBackToNorthWhenRotatingRight4times() {
        val aRover = Rover(direction = Direction.NORTH)
        val movedRover = aRover
            .receivedCommand(Command.RIGHT)
            .receivedCommand(Command.RIGHT)
            .receivedCommand(Command.RIGHT)
            .receivedCommand(Command.RIGHT)
        assertEquals(movedRover.direction, Direction.NORTH)
    }

    @Test
    fun aRoverFacingNorthShouldFaceSouthWhenRotatingLeftTwice() {
        val aRover = Rover(direction = Direction.NORTH)
        val movedRover = aRover
            .receivedCommand(Command.LEFT)
            .receivedCommand(Command.LEFT)
        assertEquals(movedRover.direction, Direction.SOUTH)
    }

    @Test
    fun aRoverFacingNorthShouldFaceBackToNorthWhenRotatingLeft4times() {
        val aRover = Rover(direction = Direction.NORTH)
        val movedRover = aRover
            .receivedCommand(Command.LEFT)
            .receivedCommand(Command.LEFT)
            .receivedCommand(Command.LEFT)
            .receivedCommand(Command.LEFT)
        assertEquals(movedRover.direction, Direction.NORTH)
    }
}
