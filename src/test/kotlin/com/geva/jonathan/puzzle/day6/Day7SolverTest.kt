package com.geva.jonathan.puzzle.day6

import com.geva.jonathan.puzzle.day7.Day7Solver
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class Day7SolverTest {
    /**
     * Test input will be read from the test resource directory
     */
    private val day7Solver = Day7Solver()

    @Test
    fun testPart1() {
        assertEquals(95437, day7Solver.solvePart1())
    }

    @Test
    fun testPart2() {
        assertEquals(24933642, day7Solver.solvePart2())

    }
}