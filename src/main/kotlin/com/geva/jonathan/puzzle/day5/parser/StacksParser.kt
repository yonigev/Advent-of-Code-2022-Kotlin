package com.geva.jonathan.puzzle.day5.parser

import com.geva.jonathan.puzzle.day5.CrateStack

/**
 * Parse input text into stacks
 */
class StacksParser : Parser<Array<CrateStack>> {

    override fun parse(input: List<String>): Array<CrateStack> {
        val stacksLineIndex: Int = input.indexOfFirst { STACKS_ENUMERATION_LINE_FINDER.matches(it) }
        val stackAmount: Int =
            LAST_STACK_NUMBER.find(input[stacksLineIndex])!!.groups["STACKNUMBER"]!!.value.toInt()
        val stacks = Array(stackAmount) { CrateStack(ArrayDeque()) }

        (stacksLineIndex - 1 downTo 0).forEach { extractCratesForLine(input[it], stacks) }
        return stacks
    }

    private fun extractCratesForLine(inputLine: String, stacks: Array<CrateStack>) {
        var matched = CRATE_FINDER.find(inputLine)

        for (i in 1..stacks.size) {
            if (matched!!.groups["NOCRATE"]?.value == null) {
                stacks[i - 1].addToTop(matched.groups["CRATE"]?.value?.get(0) ?: ' ')
            }
            matched = CRATE_FINDER.find(inputLine, matched.range.last())
        }
    }

    companion object {
        private val CRATE_FINDER = Regex("(\\[(?<CRATE>[A-Z])])|(?<NOCRATE> {4,5})")
        private val STACKS_ENUMERATION_LINE_FINDER = Regex("[0-9 ]+")
        private val LAST_STACK_NUMBER = Regex("(?<STACKNUMBER>[0-9]+)\\s*\$")
    }
}