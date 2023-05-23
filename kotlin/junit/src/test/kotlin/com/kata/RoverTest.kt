package com.kata

import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*

class RoverTest {

    @Test
    fun aDefaultRoverShouldFaceNorth() {
        val defaultRover = Rover()
        assertEquals(defaultRover.direction, Direction.NORTH)
    }
}
