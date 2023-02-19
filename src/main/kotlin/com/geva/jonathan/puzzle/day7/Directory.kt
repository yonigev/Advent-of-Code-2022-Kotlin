package com.geva.jonathan.puzzle.day7

class Directory(
    val name: String,
    private val parent: Directory?,
    private val subDirs: MutableSet<Directory> = HashSet(),
    private val subFiles: MutableSet<File> = HashSet()
) {

    var size: Int = 0

    /**
     * Cd into a subdirectory (If it doesn't exist, add it)
     * returns the new directory
     */
    fun cd(name: String): Directory {
        return when {
            name == "." || name == ".." && parent == null -> this
            name == ".." -> parent!!
            name == "/" -> root()
            else -> getSubDir(name) ?: mkdir(name) ?: this
        }
    }

    fun mkdir(name: String): Directory? {
        if (!hasSubDir(name)) {
            return Directory(name, this).also { subDirs.add(it) }
        }
        return getSubDir(name)
    }

    fun addFile(name: String, size: Int) {
        if (subDirs.none { it.name == name } && subFiles.none { it.name == name }) {
            subFiles.add(File(name, size).also { addToSize(it.sizeInBytes) })
        }
    }

    fun getAllSubDirs(): Set<Directory> {
        return HashSet<Directory>()
            .also { set -> set.add(this) }
            .also { set -> set.addAll(subDirs.flatMap { it.getAllSubDirs() }) }
    }

    private fun getSubDir(name: String): Directory? {
        return when (hasSubDir(name)) {
            true -> subDirs.first { it.name == name }
            false -> null
        }
    }

    private fun root(): Directory {

        var current = this
        while (current.parent != null) {
            current = current.parent!!
        }

        return current
    }

    private fun hasSubDir(name: String): Boolean {
        return subDirs.any { it.name == name }
    }

    private fun addToSize(sizeToAdd: Int) {
        this.size += sizeToAdd
        parent?.addToSize(sizeToAdd)
    }
}