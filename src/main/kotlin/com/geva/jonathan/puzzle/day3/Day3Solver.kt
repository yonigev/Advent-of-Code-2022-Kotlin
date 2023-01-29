package com.geva.jonathan.puzzle.day3

import com.geva.jonathan.puzzle.PuzzleSolver

class Day3Solver(day: Int = 3) : PuzzleSolver<List<String>, Int>(day) {

    override fun solvePart1(input: List<String>): Int {
        return input.fold(0) { acc, rucksack ->
            acc + findCommonChars(
                rucksack.substring(0, rucksack.length / 2),
                rucksack.substring(rucksack.length / 2)).first().priority()
        }
    }

    override fun solvePart2(input: List<String>): Int {
        return (input.indices step 3).fold(0) { acc, i ->
            acc + findCommonChars(
                findCommonChars(input[i], input[i + 1]).joinToString(""),
                findCommonChars(input[i + 1], input[i + 2]).joinToString("")).first().priority()
        }
    }

    private fun findCommonChars(str1: String, str2: String): MutableList<Char> {
        val discoveredArray = BooleanArray(53)
        val commonChars = mutableListOf<Char>()

        str1.forEach { c ->
            val indexInDiscoveredArray = c.priority()
            discoveredArray[indexInDiscoveredArray] = true
        }

        str2.forEach { c ->
            val indexInDiscoveredArray = c.priority()
            if (discoveredArray[indexInDiscoveredArray]) {
                commonChars.add(c)
            }
        }
        return commonChars
    }

    /**
     * Return a Character's priority as specified.
     */
    private fun Char.priority(): Int {
        return when {
            isLowerCase() -> code - 'a'.code + 1
            else -> code - 'A'.code + 27
        }

    }
}