package puzzle

import java.io.File

abstract class PuzzleSolver<T>(val day: Int) {
    var input: List<String> = readInput(day)

    private fun readInput(day: Int): List<String> {
        return File("src/main/resources/day$day.txt").readLines()
    }

    abstract fun solvePart1(): T

    abstract fun solvePart2(): T
}
