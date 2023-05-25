package com.kata.rover

import com.kata.planet.Dimension
import com.kata.planet.Planet
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
        assertEquals(defaultRover.position, Position(0, 0))
    }

    @Test
    fun aRoverFacingNorthShouldMove1PositionNorthWhenMovingForwards() {
        val aRover = Rover(direction = Direction.NORTH)
        val movedRover = aRover.receivedCommand(Command.FORWARDS)
        assertEquals(movedRover.position, Position(0, 1))
    }

    @Test
    fun aRoverFacingSouthShouldMove1PositionSouthWhenMovingForwards() {
        val aRover = Rover(direction = Direction.SOUTH)
        val movedRover = aRover.receivedCommand(Command.FORWARDS)
        assertEquals(movedRover.position, Position(0, -1))
    }

    @Test
    fun aRoverFacingEastShouldMove1PositionEastWhenMovingForwards() {
        val aRover = Rover(direction = Direction.EAST)
        val movedRover = aRover.receivedCommand(Command.FORWARDS)
        assertEquals(movedRover.position, Position(1, 0))
    }

    @Test
    fun aRoverFacingWestShouldMove1PositionWestWhenMovingForwards() {
        val aRover = Rover(direction = Direction.WEST)
        val movedRover = aRover.receivedCommand(Command.FORWARDS)
        assertEquals(movedRover.position, Position(-1, 0))
    }

    @Test
    fun aRoverFacingNorthShouldMove2PositionsNorthWhenMovingForwardsTwice() {
        val aRover = Rover(direction = Direction.NORTH)
        val movedRover = aRover.receivedCommands(
            listOf(
                Command.FORWARDS,
                Command.FORWARDS
            )
        )
        assertEquals(movedRover.position, Position(0, 2))
    }

    @Test
    fun aRoverFacingSouthShouldMove2PositionsSouthWhenMovingForwardsTwice() {
        val aRover = Rover(direction = Direction.SOUTH)
        val movedRover = aRover.receivedCommands(
            listOf(
                Command.FORWARDS,
                Command.FORWARDS
            )
        )
        assertEquals(movedRover.position, Position(0, -2))
    }

    @Test
    fun aRoverFacingEastShouldMove2PositionsEastWhenMovingForwardsTwice() {
        val aRover = Rover(direction = Direction.EAST)
        val movedRover = aRover.receivedCommands(
            listOf(
                Command.FORWARDS,
                Command.FORWARDS
            )
        )
        assertEquals(movedRover.position, Position(2, 0))
    }

    @Test
    fun aRoverFacingWestShouldMove2PositionsWestWhenMovingForwardsTwice() {
        val aRover = Rover(direction = Direction.WEST)
        val movedRover = aRover.receivedCommands(
            listOf(
                Command.FORWARDS,
                Command.FORWARDS
            )
        )
        assertEquals(movedRover.position, Position(-2, 0))
    }

    @Test
    fun aRoverFacingNorthShouldMove1PositionSouthWhenMovingBackwards() {
        val aRover = Rover(direction = Direction.NORTH)
        val movedRover = aRover.receivedCommand(Command.BACKWARDS)
        assertEquals(movedRover.position, Position(0, -1))
    }

    @Test
    fun aRoverFacingSouthShouldMove1PositionNorthWhenMovingBackwards() {
        val aRover = Rover(direction = Direction.SOUTH)
        val movedRover = aRover.receivedCommand(Command.BACKWARDS)
        assertEquals(movedRover.position, Position(0, 1))
    }

    @Test
    fun aRoverFacingEastShouldMove1PositionWestWhenMovingBackwards() {
        val aRover = Rover(direction = Direction.EAST)
        val movedRover = aRover.receivedCommand(Command.BACKWARDS)
        assertEquals(movedRover.position, Position(-1, 0))
    }

    @Test
    fun aRoverFacingWestShouldMove1PositionEastWhenMovingBackwards() {
        val aRover = Rover(direction = Direction.WEST)
        val movedRover = aRover.receivedCommand(Command.BACKWARDS)
        assertEquals(movedRover.position, Position(1, 0))
    }

    @Test
    fun aRoverFacingNorthShouldMove2PositionsSouthWhenMovingBackwardsTwice() {
        val aRover = Rover(direction = Direction.NORTH)
        val movedRover = aRover.receivedCommands(
            listOf(
                Command.BACKWARDS,
                Command.BACKWARDS
            )
        )
        assertEquals(movedRover.position, Position(0, -2))
    }

    @Test
    fun aRoverFacingSouthShouldMove2PositionsNorthWhenMovingBackwardsTwice() {
        val aRover = Rover(direction = Direction.SOUTH)
        val movedRover = aRover.receivedCommands(
            listOf(
                Command.BACKWARDS,
                Command.BACKWARDS
            )
        )
        assertEquals(movedRover.position, Position(0, 2))
    }

    @Test
    fun aRoverFacingEastShouldMove2PositionsWestWhenMovingBackwardsTwice() {
        val aRover = Rover(direction = Direction.EAST)
        val movedRover = aRover.receivedCommands(
            listOf(
                Command.BACKWARDS,
                Command.BACKWARDS
            )
        )
        assertEquals(movedRover.position, Position(-2, 0))
    }

    @Test
    fun aRoverFacingWestShouldMove2PositionsEastWhenMovingBackwardsTwice() {
        val aRover = Rover(direction = Direction.WEST)
        val movedRover = aRover.receivedCommands(
            listOf(
                Command.BACKWARDS,
                Command.BACKWARDS
            )
        )
        assertEquals(movedRover.position, Position(2, 0))
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
        val movedRover = aRover.receivedCommands(
            listOf(
                Command.RIGHT,
                Command.RIGHT
            )
        )
        assertEquals(movedRover.direction, Direction.SOUTH)
    }

    @Test
    fun aRoverFacingNorthShouldFaceBackToNorthWhenRotatingRight4times() {
        val aRover = Rover(direction = Direction.NORTH)
        val movedRover = aRover
            .receivedCommands(
                listOf(
                    Command.RIGHT,
                    Command.RIGHT,
                    Command.RIGHT,
                    Command.RIGHT
                )
            )
        assertEquals(movedRover.direction, Direction.NORTH)
    }

    @Test
    fun aRoverFacingNorthShouldFaceSouthWhenRotatingLeftTwice() {
        val aRover = Rover(direction = Direction.NORTH)
        val movedRover = aRover
            .receivedCommands(
                listOf(
                    Command.LEFT,
                    Command.LEFT
                )
            )
        assertEquals(movedRover.direction, Direction.SOUTH)
    }

    @Test
    fun aRoverFacingNorthShouldFaceBackToNorthWhenRotatingLeft4times() {
        val aRover = Rover(direction = Direction.NORTH)
        val movedRover = aRover
            .receivedCommands(
                listOf(
                    Command.LEFT,
                    Command.LEFT,
                    Command.LEFT,
                    Command.LEFT
                )
            )
        assertEquals(movedRover.direction, Direction.NORTH)
    }

    @Test
    fun aRoverFacingNorthShouldFaceWestAndBeAtPosition2_0WhenReceivingAListOfLeftForwardsForwardsLeftForwardsRightBackwardsCommands() {
        val aRover = Rover(direction = Direction.NORTH)
        val movedRover = aRover.receivedCommands(
            listOf(
                Command.LEFT,
                Command.FORWARDS,
                Command.FORWARDS,
                Command.LEFT,
                Command.FORWARDS,
                Command.RIGHT,
                Command.BACKWARDS
            )
        )
        assertEquals(movedRover.direction, Direction.WEST)
        assertEquals(movedRover.position, Position(2, 0))
    }

    @Test
    fun aRoverFacingNorthShouldReturnAtItsPositionWhenReceivingAListOfRightForwardsCommands4Times() {
        val aRover = Rover(direction = Direction.NORTH)
        val movedRover = aRover.receivedCommands(
            listOf(
                Command.RIGHT,
                Command.FORWARDS,
                Command.RIGHT,
                Command.FORWARDS,
                Command.RIGHT,
                Command.FORWARDS,
                Command.RIGHT,
                Command.FORWARDS
            )
        )
        assertEquals(movedRover.direction, Direction.NORTH)
        assertEquals(movedRover.position, Position(0, 0))
    }

    @Test
    fun aDefaultRoverShouldBeOnPlanetMars() {
        val defaultRover = Rover()
        assertEquals(defaultRover.planet, Planet.mars())
    }

    @Test
    fun aRoverOnThePlanetsTopEdgeMovingForwardsNorthShouldBeAtThePlanetsBottomEdge() {
        val venus = Planet(Dimension(3, 3))
        val aRover = Rover(direction = Direction.NORTH, position = Position(0, 1), planet = venus)
        val movedRover = aRover.receivedCommand(Command.FORWARDS)
        assertEquals(movedRover.position, Position(0, -1))
    }

    @Test
    fun aRoverOnThePlanetsBottomEdgeMovingForwardsSouthShouldBeAtThePlanetsTopEdge() {
        val venus = Planet(Dimension(3, 3))
        val aRover = Rover(direction = Direction.SOUTH, position = Position(0, -1), planet = venus)
        val movedRover = aRover.receivedCommand(Command.FORWARDS)
        assertEquals(movedRover.position, Position(0, 1))
    }

    @Test
    fun aRoverOnThePlanetsTopEdgeMovingBackwardsSouthShouldBeAtThePlanetsBottomEdge() {
        val venus = Planet(Dimension(3, 3))
        val aRover = Rover(direction = Direction.SOUTH, position = Position(0, 1), planet = venus)
        val movedRover = aRover.receivedCommand(Command.BACKWARDS)
        assertEquals(movedRover.position, Position(0, -1))
    }

    @Test
    fun aRoverOnThePlanetsBottomEdgeMovingBackwardsNorthShouldBeAtThePlanetsTopEdge() {
        val venus = Planet(Dimension(3, 3))
        val aRover = Rover(direction = Direction.NORTH, position = Position(0, -1), planet = venus)
        val movedRover = aRover.receivedCommand(Command.BACKWARDS)
        assertEquals(movedRover.position, Position(0, 1))
    }

    @Test
    fun aRoverOnThePlanetsRightEdgeMovingForwardsEastShouldBeAtThePlanetsLeftEdge() {
        val venus = Planet(Dimension(3, 3))
        val aRover = Rover(direction = Direction.EAST, position = Position(-1, 0), planet = venus)
        val movedRover = aRover.receivedCommand(Command.FORWARDS)
        assertEquals(movedRover.position, Position(1, 0))
    }

    @Test
    fun aRoverOnThePlanetsLeftEdgeMovingForwardsWestShouldBeAtThePlanetsRightEdge() {
        val venus = Planet(Dimension(3, 3))
        val aRover = Rover(direction = Direction.WEST, position = Position(1, 0), planet = venus)
        val movedRover = aRover.receivedCommand(Command.FORWARDS)
        assertEquals(movedRover.position, Position(-1, 0))
    }

    @Test
    fun aRoverOnThePlanetsRightEdgeMovingBackwardsEastShouldBeAtThePlanetsLeftEdge() {
        val venus = Planet(Dimension(3, 3))
        val aRover = Rover(direction = Direction.WEST, position = Position(-1, 0), planet = venus)
        val movedRover = aRover.receivedCommand(Command.BACKWARDS)
        assertEquals(movedRover.position, Position(1, 0))
    }

    @Test
    fun aRoverOnThePlanetsLeftEdgeMovingBackwardsWestShouldBeAtThePlanetsRightEdge() {
        val venus = Planet(Dimension(3, 3))
        val aRover = Rover(direction = Direction.EAST, position = Position(1, 0), planet = venus)
        val movedRover = aRover.receivedCommand(Command.BACKWARDS)
        assertEquals(movedRover.position, Position(-1, 0))
    }

    @Test
    fun aDefaultRoverShouldBeOnMarsWithoutAnyObstacles() {
        val defaultRover = Rover()
        assertEquals(defaultRover.planet, Planet.mars())
    }

    @Test
    fun aRoverShouldReportAnObstacleInFrontOfIt() {
        val obstacles = listOf(Position(0, 1))
        val mars = Planet.mars(obstacles)
        val aRover = Rover(planet = mars)
        assertThrows<ObstacleException> {
            aRover.receivedCommand(Command.FORWARDS)
        }
    }

    @Test
    fun aDefaultRoverReceivesAListOfCommandsWithTheSecondOneThatIsAnObstacle() {
        val obstacles = listOf(Position(0, 2))
        val mars = Planet.mars(obstacles)
        val aDefaultRover = Rover(planet = mars)
        assertThrows<ObstacleException> {
            aDefaultRover.receivedCommands(
                listOf(
                    Command.FORWARDS,
                    Command.FORWARDS,
                    Command.FORWARDS,
                    Command.FORWARDS,
                )
            )
        }
    }

    @Test
    fun aRoverShouldReportAnObstacleBehindItMovingBackwards() {
        val obstacles = listOf(Position(0, -1))
        val mars = Planet.mars(obstacles)
        val aRover = Rover(planet = mars)
        assertThrows<ObstacleException> { aRover.receivedCommand(Command.BACKWARDS) }
    }

    @Test
    fun aRoverShouldNotReportAnObstacleWhenRotatingLeft() {
        val obstacles = listOf(Position(0, -1))
        val mars = Planet.mars(obstacles)
        val aRover = Rover(planet = mars)
        assertDoesNotThrow { aRover.receivedCommand(Command.LEFT) }
    }

    @Test
    fun aRoverShouldNotReportAnObstacleBehindItMovingForwards() {
        val obstacles = listOf(Position(0, -1))
        val mars = Planet.mars(obstacles)
        val aRover = Rover(planet = mars)
        assertDoesNotThrow { aRover.receivedCommand(Command.FORWARDS) }
    }

    @Test
    fun aRoverShouldNotReportAnObstacleInFrontOfItMovingBackwards() {
        val obstacles = listOf(Position(0, 1))
        val mars = Planet.mars(obstacles)
        val aRover = Rover(planet = mars)
        assertDoesNotThrow { aRover.receivedCommand(Command.BACKWARDS) }
    }
}
