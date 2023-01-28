package puzzle.day5

/**
 * A crate stack.
 * created for abstraction & clearance
 */
class CrateStack (private val innerStack: ArrayDeque<Char>){

    fun addToTop(crate: Char) {
        innerStack.addLast(crate)
    }

    fun addToTop(crates : List<Char>) {
        crates.forEach { innerStack.addLast(it) }
    }

    fun removeFromTop() : Char {
        return innerStack.removeLast()
    }

    fun removeFromTop(n:Int): List<Char> {
         return (1..n).map {
            innerStack.removeLast()
        }.reversed()
    }

    fun peekTop(): Char {
        return innerStack.last()
    }
}