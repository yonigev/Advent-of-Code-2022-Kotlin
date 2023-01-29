package com.geva.jonathan.puzzle.day5

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class Day5SolverTest {
    /**
     * Test input will be read from the test resource directory
     */
    private val day5Solver = Day5Solver()

    @Test
    fun testPart1() {
        assertEquals("CMZ", day5Solver.solvePart1())
    }

    @Test
    fun testPart2() {
        assertEquals("MCD", day5Solver.solvePart2())
    }
}