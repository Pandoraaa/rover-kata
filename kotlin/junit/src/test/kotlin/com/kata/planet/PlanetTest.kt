package com.kata.planet

import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*

class PlanetTest {
    @Test
    fun canBeCreatedWithAGivenDimension() {
        val planet = Planet(Dimension(2,2))
        assertEquals(planet.dimension, Dimension(2,2))
    }
}