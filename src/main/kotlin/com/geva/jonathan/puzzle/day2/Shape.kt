package com.geva.jonathan.puzzle.day2

enum class Shape {
    ROCK, PAPER, SCISSORS;

    /**
     * Returns which shape it beats.
     * i.e. for A (Rock), C will be returned. (Scissors)
     */
    companion object {
        fun forInputChar(c: Char): Shape {
            return when (c) {
                'A' -> ROCK
                'B' -> PAPER
                else -> SCISSORS
            }
        }
    }
}

/**
 * Specifies the relation between Shapes
 */
fun Shape.beats() : Shape {
    return when(this) {
        Shape.ROCK -> Shape.SCISSORS
        Shape.PAPER -> Shape.ROCK
        // SCISSORS
        else -> Shape.PAPER

    }
}


/**
 * Specifies the relation between Shapes
 */
fun Shape.loses() : Shape {
    return when(this) {
        Shape.ROCK -> Shape.PAPER
        Shape.PAPER -> Shape.SCISSORS
        // SCISSORS
        else -> Shape.ROCK

    }
}