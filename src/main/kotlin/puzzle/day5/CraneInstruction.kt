package puzzle.day5

import puzzle.day5.parser.INSTRUCTION_LINE

data class CraneInstruction(val times: Int, val sourceStack: Int, val destStack: Int) {
    constructor(rawInput: String) : this(
        INSTRUCTION_LINE.find(rawInput)!!.groups["TIMES"]!!.value.toInt(),
        INSTRUCTION_LINE.find(rawInput)!!.groups["FROM"]!!.value.toInt(),
        INSTRUCTION_LINE.find(rawInput)!!.groups["TO"]!!.value.toInt(),
    )
}
