package puzzle.day5.parser

interface Parser<O> {
    fun parse(input: List<String>): O
}