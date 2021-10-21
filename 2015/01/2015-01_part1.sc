import $file.^.^.Util

val input = Util.readFullInputFile()

val openingBrackets = input.count(_ == '(')
val closingBrackets = input.count(_ == ')')

val level = openingBrackets - closingBrackets

Util.printSolution(level)
