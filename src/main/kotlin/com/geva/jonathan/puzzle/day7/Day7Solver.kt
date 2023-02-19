package com.geva.jonathan.puzzle.day7

import com.geva.jonathan.puzzle.PuzzleSolver

val COMMAND_LINE = Regex("^\\s*\\\$\\s*(?<COMMAND>[a-zA-Z]+)(\\s+(?<ARGUMENT>.+))?\\s*\$")
val DIR_LINE = Regex("^\\s*\\s*([a-zA-Z]+)\\s*(?<DIR>\\w+)\\s*\$")
val FILE_LINE = Regex("^\\s*(?<SIZE>[0-9]+)\\s*(?<NAME>(\\w|[.,])+)")

class Day7Solver(day: Int = 7) : PuzzleSolver<Int>(day) {

    private val maxAvailableBytes = 70000000
    private val updateRequiredBytes = 30000000

    override fun solvePart1(input: List<String>): Int {
        val fileSystem = inferFileSystemTree(input)
        val allSubDirs = fileSystem.getAllSubDirs()
        return allSubDirs.filter { it.size <= 100000 }.sumOf { it.size }
    }

    override fun solvePart2(input: List<String>): Int {
        val fileSystem = inferFileSystemTree(input)
        val allSubDirs = fileSystem.getAllSubDirs().sortedBy { it.size }
        val used = allSubDirs.first { it.name == "/" }.size
        val available = maxAvailableBytes - used

        if (available >= updateRequiredBytes) {
            return 0
        }

        return allSubDirs.first { available + it.size >= updateRequiredBytes }.size
    }

}