import com.geva.jonathan.puzzle.day1.Day1Solver
import com.geva.jonathan.puzzle.day2.Day2Solver
import com.geva.jonathan.puzzle.day3.Day3Solver
import com.geva.jonathan.puzzle.day4.Day4Solver
import com.geva.jonathan.puzzle.day5.Day5Solver

fun main() {
    val puzzles = listOf(
        Day1Solver(),
        Day2Solver(),
        Day3Solver(),
        Day4Solver(),
        Day5Solver()
    )

    puzzles.forEach {
        with(it) {
            log.info { "Solution for Day${it.day} part1: ${solvePart1()}" }
            log.info { "Solution for Day${it.day} part2: ${solvePart2()}" }
        }
    }
}