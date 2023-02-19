package com.geva.jonathan.puzzle.day2

import com.geva.jonathan.puzzle.PuzzleSolver

class Day2Solver(day: Int = 2) : PuzzleSolver<Int>(day) {

    /**
     * Score for the selected shape
     */
    private fun selectedShapeScore(shape: Shape): Int {
        return when (shape) {
            Shape.ROCK -> 1
            Shape.PAPER -> 2
            Shape.SCISSORS -> 3
        }
    }

    /**
     * Score for the round's outcome
     */
    private fun roundScore(opponentShape: Shape, selectedShape: Shape): Int {
        return when {
            opponentShape == selectedShape -> 3
            opponentShape == selectedShape.beats() -> 6
            opponentShape.beats() == selectedShape -> 0
            else -> 0
        }
    }

    override fun solvePart1(input: List<String>): Int {
        var score = 0
        input.forEach {
            val opponentShape = Shape.forInputChar(it[0])
            val selectedShape = when (it[2]) {
                'X' -> Shape.ROCK
                'Y' -> Shape.PAPER
                else -> Shape.SCISSORS

            }

            score += selectedShapeScore(selectedShape) + roundScore(opponentShape, selectedShape)
        }
        return score
    }

    override fun solvePart2(input: List<String>): Int {
        var score = 0
        input.forEach {
            val opponentShape = Shape.forInputChar(it[0])

            val selectedShape = when (it[2]) {
                'X' -> opponentShape.beats() // lose
                'Y' -> opponentShape // draw
                else -> opponentShape.loses() // win

            }
            score += selectedShapeScore(selectedShape) + roundScore(opponentShape, selectedShape)
        }
        return score
    }

}