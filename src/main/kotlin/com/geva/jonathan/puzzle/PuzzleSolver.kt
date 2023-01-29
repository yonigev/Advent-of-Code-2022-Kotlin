package com.geva.jonathan.puzzle

import mu.KotlinLogging

abstract class PuzzleSolver<T>(val day: Int) {
    val log = KotlinLogging.logger {}
    protected var input: List<String> = readInput(day)

    private fun readInput(day: Int): List<String> {
        return object {}.javaClass.getResource("/input/day${day}.txt")?.readText()?.lines() ?: listOf()
    }

    abstract fun solvePart1(): T

    abstract fun solvePart2(): T
}
