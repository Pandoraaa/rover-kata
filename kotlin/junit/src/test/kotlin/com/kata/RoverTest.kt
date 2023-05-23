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
    fun aRoverFacingNorthShouldMove1PositionNorthWhenMovingForward() {
        val aRover = Rover(direction = Direction.NORTH)
        val movedRover = aRover.receivedCommand(Command.FORWARDS)
        assertEquals(movedRover.position, Position(0,1))
    }

    @Test
    fun aRoverFacingSouthShouldMove1PositionSouthWhenMovingForward() {
        val aRover = Rover(direction = Direction.SOUTH)
        val movedRover = aRover.receivedCommand(Command.FORWARDS)
        assertEquals(movedRover.position, Position(0,-1))
    }

    @Test
    fun aRoverFacingEastShouldMove1PositionEastWhenMovingForward() {
        val aRover = Rover(direction = Direction.EAST)
        val movedRover = aRover.receivedCommand(Command.FORWARDS)
        assertEquals(movedRover.position, Position(1,0))
    }

    @Test
    fun aRoverFacingWestShouldMove1PositionWestWhenMovingForward() {
        val aRover = Rover(direction = Direction.WEST)
        val movedRover = aRover.receivedCommand(Command.FORWARDS)
        assertEquals(movedRover.position, Position(-1,0))
    }

    @Test
    fun aRoverFacingNorthShouldMove2PositionsNorthWhenMovingForwardTwice() {
        val aRover = Rover(direction = Direction.NORTH)
        val movedRover = aRover.receivedCommand(Command.FORWARDS).receivedCommand(Command.FORWARDS)
        assertEquals(movedRover.position, Position(0,2))
    }

    @Test
    fun aRoverFacingSouthShouldMove2PositionsSouthWhenMovingForwardTwice() {
        val aRover = Rover(direction = Direction.SOUTH)
        val movedRover = aRover.receivedCommand(Command.FORWARDS).receivedCommand(Command.FORWARDS)
        assertEquals(movedRover.position, Position(0,-2))
    }

    @Test
    fun aRoverFacingEastShouldMove2PositionsEastWhenMovingForwardTwice() {
        val aRover = Rover(direction = Direction.EAST)
        val movedRover = aRover.receivedCommand(Command.FORWARDS).receivedCommand(Command.FORWARDS)
        assertEquals(movedRover.position, Position(2,0))
    }

    @Test
    fun aRoverFacingWestShouldMove2PositionsWestWhenMovingForwardTwice() {
        val aRover = Rover(direction = Direction.WEST)
        val movedRover = aRover.receivedCommand(Command.FORWARDS).receivedCommand(Command.FORWARDS)
        assertEquals(movedRover.position, Position(-2,0))
    }
}
