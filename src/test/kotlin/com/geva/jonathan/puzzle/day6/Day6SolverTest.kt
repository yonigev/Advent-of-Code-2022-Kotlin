package com.geva.jonathan.puzzle.day6

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class Day6SolverTest {
    /**
     * Test input will be read from the test resource directory
     */
    private val day6Solver = Day6Solver()

    @Test
    fun testPart1() {

        assertEquals("CMZ", day6Solver.solvePart1("mjqjpqmgbljsphdztnvjfqwrcgsmlb"))
    }

    @Test
    fun testPart2() {
        assertEquals("MCD", day6Solver.solvePart2())
    }
}