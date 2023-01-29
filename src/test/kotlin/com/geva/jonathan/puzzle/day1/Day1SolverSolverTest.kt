package com.geva.jonathan.puzzle.day1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class Day1SolverSolverTest {
    /**
     * Test input will be read from the test resource directory
     */
    private val day1Solver = Day1Solver()

    @Test
    fun testPart1() {
        assertEquals(24000, day1Solver.solvePart1())
    }

    @Test
    fun testPart2() {
        assertEquals(45000, day1Solver.solvePart2())
    }


}