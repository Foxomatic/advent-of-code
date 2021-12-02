import ammonite.ops._

def readFullInputFile(): String = read(pwd / "input")

def readInputFileLines(): List[String] = read.lines(pwd / "input").toList

def printSolution(solution: Any): Unit = {
  println("The solution is:")
  println(solution.toString)
}

implicit class StringUtils(val string: String) {
  def isNumeric: Boolean = string forall Character.isDigit
}
