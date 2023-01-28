package puzzle.day5.parser

import puzzle.day5.CraneInstruction
val INSTRUCTION_LINE = Regex("^\\s*move ?(?<TIMES>\\d+) ?from ?(?<FROM>\\d+) ?to ?(?<TO>\\d+)\\s*\$")

class InstructionsParser : Parser<List<CraneInstruction>> {
    override fun parse(input: List<String>): List<CraneInstruction> {
        return input.subList(input.indexOfFirst { INSTRUCTION_LINE.matches(it) }, input.size)
            .map { CraneInstruction(it) }
    }
}