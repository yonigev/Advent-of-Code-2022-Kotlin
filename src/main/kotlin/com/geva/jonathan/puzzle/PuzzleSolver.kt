package com.geva.jonathan.puzzle

import mu.KotlinLogging

abstract class PuzzleSolver<I, T>(val day: Int) {
    val log = KotlinLogging.logger {}

    fun readInput(day: Int): I {
        return (object {}.javaClass.getResource("/input/day${day}.txt")?.readText()?.lines() ?: listOf()) as I
    }

    abstract fun solvePart1(input: I = readInput(day)): T

    abstract fun solvePart2(input: I = readInput(day)): T
}
