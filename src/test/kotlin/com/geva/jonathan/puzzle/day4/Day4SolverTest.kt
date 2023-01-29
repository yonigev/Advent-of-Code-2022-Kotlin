package com.geva.jonathan.puzzle.day4

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class Day4SolverTest {
    /**
     * Test input will be read from the test resource directory
     */
    private val day4Solver = Day4Solver()

    @Test
    fun testPart1() {
        assertEquals(2, day4Solver.solvePart1())
    }

    @Test
    fun testPart2() {
        assertEquals(4, day4Solver.solvePart2())
    }
}