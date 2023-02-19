package com.geva.jonathan.puzzle.day6

import com.geva.jonathan.puzzle.PuzzleSolver
import kotlin.math.min

class Day6Solver(day: Int = 6) : PuzzleSolver<Int>(day) {

    override fun solvePart1(input: List<String>): Int {

        return findFirstNDifferentChars(input.first(), 4)
    }

    override fun solvePart2(input: List<String>): Int {
        return findFirstNDifferentChars(input.first(), 14)
    }

    private fun findFirstNDifferentChars(input: String, n: Int): Int {

        for (i in 0..input.length) {
            val set = input.subSequence(i, min(i + n, input.length)).toHashSet()
            if (set.size == n) {
                return i + n
            }
        }
        return 0
    }
}