package puzzle.day1

import puzzle.PuzzleSolver

class Day1(day: Int = 1) : PuzzleSolver<Int>(day) {


    override fun solvePart1(): Int {
        val calories = createElveCaloriesArray()
        return calories[0]
    }

    override fun solvePart2(): Int {
        val calories = createElveCaloriesArray()
        return calories[0] + calories[1] + calories[2]
    }


    private fun createElveCaloriesArray(): List<Int> {
        var curr = 0
        val calories = mutableListOf<Int>()
        input.forEach {
            if (it.isEmpty()) {
                calories.add(curr)
                curr = 0
            }
            else {
                curr += it.toInt()
            }
        }

        return calories.sortedDescending()
    }
}