package com.geva.jonathan.puzzle.day2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class Day2SolverTest {
    /**
     * Test input will be read from the test resource directory
     */
    private val day2Solver = Day2Solver()

    @Test
    fun testPart1() {
        assertEquals(15, day2Solver.solvePart1())
    }

    @Test
    fun testPart2() {
        assertEquals(12, day2Solver.solvePart2())
    }
}