package com.kata.planet

import com.kata.rover.Position
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*

class PlanetTest {
    @Test
    fun onAPlanet3by3AnythingBut00IsAnEdge() {
        val planet3x3 = Planet(planetSize(3,3))

        assertFalse(planet3x3.isAnEdge(Position(0,0)))

        // Top edge
        assertTrue(planet3x3.isAnEdge(Position(-1,1)))
        assertTrue(planet3x3.isAnEdge(Position(0,1)))
        assertTrue(planet3x3.isAnEdge(Position(1,1)))

        // Bottom edge
        assertTrue(planet3x3.isAnEdge(Position(-1,-1)))
        assertTrue(planet3x3.isAnEdge(Position(0,-1)))
        assertTrue(planet3x3.isAnEdge(Position(1,-1)))

        //Middle left edge
        assertTrue(planet3x3.isAnEdge(Position(-1,0)))

        // Middle right edge
        assertTrue(planet3x3.isAnEdge(Position(1,0)))
    }
}