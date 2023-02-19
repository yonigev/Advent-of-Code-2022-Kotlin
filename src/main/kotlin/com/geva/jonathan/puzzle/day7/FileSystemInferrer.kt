package com.geva.jonathan.puzzle.day7

import java.util.*


fun inferFileSystemTree(input: List<String>): Directory {
    val root = Directory("/", null)
    var currentDirectory = root

    var i = 0
    while (i < input.size) {
        currentDirectory = processLine(currentDirectory, input[i])
        i ++
    }
    return root
}

private fun processLine(currentDirectory: Directory, line: String): Directory {
    return if (line[0] == '$') {
        parseCommandLine(currentDirectory, line)
    } else {
        if (DIR_LINE.matches(line)) {
            val dirLine = DIR_LINE.find(line)!!
            currentDirectory.mkdir(dirLine.groups["DIR"]!!.value)
        }

        if (FILE_LINE.matches(line)) {
            val fileLine = FILE_LINE.find(line)!!
            currentDirectory.addFile(fileLine.groups["NAME"]!!.value, fileLine.groups["SIZE"]!!.value.toInt())
        }
        currentDirectory
    }
}

private fun parseCommandLine(currentDirectory: Directory, commandLine: String): Directory {
    if (commandLine[0] != '$') {
        throw InputMismatchException("Given input line is not a command! $commandLine")
    }

    val matched =
        COMMAND_LINE.find(commandLine) ?: throw InputMismatchException("Invalid command line! $commandLine")
    val command = matched.groups["COMMAND"]?.value
    val argument = matched.groups["ARGUMENT"]?.value

    return if ("cd" == command) {
        currentDirectory.cd(argument!!)
    }
    else {
        currentDirectory
    }
}
