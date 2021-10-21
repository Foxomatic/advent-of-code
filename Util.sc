import ammonite.ops._

def readFullInputFile(): String = read(pwd / "input")

def printSolution(solution: Any): Unit = {
  println("The solution is:")
  println(solution.toString)
}