package puzzle.day1

import puzzle.PuzzleSolver

class Day1(day: Int = 1) : PuzzleSolver<Int>(day) {

    private var calories: MutableList<Int> = mutableListOf()

    override fun solvePart1(): Int {
        var curr = 0
        input.forEach {
            if (it.isEmpty()) {
                calories.add(curr)
                curr = 0
            }
            else {
                curr += it.toInt()
            }
        }
        calories.sortedDescending()
        return calories[0]
    }

    override fun solvePart2(): Int {
        return calories[0] + calories[1] + calories[2]
    }
}