import com.geva.jonathan.puzzle.day7.Day7Solver

fun main() {
    val puzzles = listOf(
//        Day1Solver(),
//        Day2Solver(),
//        Day3Solver(),
//        Day4Solver(),
//        Day5Solver(),
//        Day6Solver(),
        Day7Solver()

    )

    puzzles.forEach {
        with(it) {
            log.info { "Solution for Day${it.day} part1: ${solvePart1()}" }
            log.info { "Solution for Day${it.day} part2: ${solvePart2()}" }
        }
    }
}