import mu.KotlinLogging
import puzzle.day1.Day1
import puzzle.day2.Day2
import puzzle.day3.Day3
import puzzle.day4.Day4

private val log = KotlinLogging.logger {}

fun main() {

    val puzzles = listOf(
//        Day1(),
//        Day2(),
//        Day3(),
        Day4()
    )

    puzzles.forEach {
        with(it) {
            log.info { "Solution for Day${it.day} part1: ${solvePart1()}" }
            log.info { "Solution for Day${it.day} part2: ${solvePart2()}" }
        }
    }
}