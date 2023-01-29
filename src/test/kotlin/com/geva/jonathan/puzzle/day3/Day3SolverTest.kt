package com.geva.jonathan.puzzle.day3

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class Day3SolverTest {
    /**
     * Test input will be read from the test resource directory
     */
    private val day3Solver = Day3Solver()

    @Test
    fun testPart1() {
        assertEquals(157, day3Solver.solvePart1())
    }

    @Test
    fun testPart2() {
        assertEquals(70, day3Solver.solvePart2())
    }
}