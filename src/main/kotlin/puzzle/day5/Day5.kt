package puzzle.day5

import puzzle.PuzzleSolver
import puzzle.day5.parser.InstructionsParser
import puzzle.day5.parser.StacksParser

class Day5(day: Int = 5) : PuzzleSolver<String>(day) {
    private val stacksParser = StacksParser()
    private val instructionsParser = InstructionsParser()

    override fun solvePart1(): String {
        val stacks: Array<CrateStack> = stacksParser.parse(input)
        val instructions = instructionsParser.parse(input)
        instructions.forEach { performInstruction(it, stacks) }
        return String(stacks.map { it.peekTop() }.toCharArray())
    }

    override fun solvePart2(): String {
        val stacks: Array<CrateStack> = stacksParser.parse(input)
        val instructions = instructionsParser.parse(input)
        instructions.forEach { performInstruction(it, stacks, stable = true) }
        return String(stacks.map { it.peekTop() }.toCharArray())
    }


    /**
     * Perform an instruction.
     * if stable is true - Instructions that move N creates will move them and maintain the order
     */
    private fun performInstruction(instruction: CraneInstruction, stacks: Array<CrateStack>, stable: Boolean = false) {
        val sourceStack = stacks[instruction.sourceStack - 1]
        val destStack = stacks[instruction.destStack - 1]
        if (stable) {
            val removed = sourceStack.removeFromTop(instruction.times)
            destStack.addToTop(removed)
            return
        }

        (0 until instruction.times).forEach { _ ->
            val crate = sourceStack.removeFromTop()
            destStack.addToTop(crate)
            log.info { "Moved crate $crate from stack ${instruction.sourceStack} to ${instruction.destStack} " }
        }
    }
}