package com.geva.jonathan.puzzle

import mu.KotlinLogging

abstract class PuzzleSolver<T>(val day: Int) {
    val log = KotlinLogging.logger {}

    fun readInput(day: Int): List<String> {
        return (object {}.javaClass.getResource("/input/day${day}.txt")?.readText()?.lines() ?: listOf())
    }

    abstract fun solvePart1(input: List<String> = readInput(day)): T

    abstract fun solvePart2(input: List<String> = readInput(day)): T
}
