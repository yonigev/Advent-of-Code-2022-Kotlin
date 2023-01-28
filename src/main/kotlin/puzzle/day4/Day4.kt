package puzzle.day4

import puzzle.PuzzleSolver

const val ELF_SEPARATOR: Char = ','
const val TASK_SEPARATOR: Char = '-'

class Day4(day: Int = 4) : PuzzleSolver<Int>(day) {

    override fun solvePart1(): Int {
        return input.fold(0) { acc, it ->
            val (elf1Tasks, elf2Tasks) = getElfTasks(it)
            acc + if (elf1Tasks.fullyContains(elf2Tasks) || elf2Tasks.fullyContains(elf1Tasks)) 1 else 0
        }
    }

    override fun solvePart2(): Int {
        return input.fold(0) { acc, it ->
            val (elf1Tasks, elf2Tasks) = getElfTasks(it)
            acc + if (elf1Tasks.overlaps(elf2Tasks)) 1 else 0
        }
    }

    private fun getElfTasks(elvesTasks: String): Pair<IntRange, IntRange> {
        val elfSeparator = elvesTasks.indexOf(ELF_SEPARATOR)
        return expandElfAssignment(elvesTasks.substring(0, elfSeparator)) to
                expandElfAssignment(
                    elvesTasks.substring(elfSeparator + 1)
                )
    }

    /**
     * Conversion to IntRange is not necessary but clearer
     */
    private fun expandElfAssignment(elfAssignments: String): IntRange {
        val taskSeparator = elfAssignments.indexOf(TASK_SEPARATOR)
        val from = elfAssignments.substring(0, taskSeparator).toInt()
        val to = elfAssignments.substring(taskSeparator + 1).toInt()
        return from..to
    }

    private fun IntRange.fullyContains(anotherRange: IntRange): Boolean {
        return this.first <= anotherRange.first() && this.last >= anotherRange.last()
    }

    private fun IntRange.overlaps(anotherRange: IntRange): Boolean {
        return anotherRange.first in this
                || anotherRange.last in this
                || this.first in anotherRange
                || last in anotherRange
    }
}