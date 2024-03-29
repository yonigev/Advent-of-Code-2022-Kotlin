package com.geva.jonathan.puzzle.day1

import com.geva.jonathan.puzzle.PuzzleSolver

class Day1Solver(day: Int = 1) : PuzzleSolver<Int>(day) {

    override fun solvePart1(input: List<String>): Int {
        val calories = createElvesCaloriesArray(input)
        return calories[0]
    }

    override fun solvePart2(input: List<String>): Int {
        val calories = createElvesCaloriesArray(input)
        return calories[0] + calories[1] + calories[2]
    }


    private fun createElvesCaloriesArray(input: List<String>): List<Int> {
        var curr = 0
        val calories = mutableListOf<Int>()
        input.forEachIndexed { i, it ->
            when {
                it.isEmpty() -> {
                    calories.add(curr)
                    curr = 0
                }
                i == input.size - 1 -> {
                    calories.add(curr + it.toInt())
                }
                else -> {
                    curr += it.toInt()
                }
            }
        }
        return calories.sortedDescending()
    }
}