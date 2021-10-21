import $file.^.^.Util

import scala.annotation.tailrec

@tailrec
def visits(locations: List[(Int, Int)], instructions: String): List[(Int, Int)] = {
  if (instructions.isEmpty) locations
  else {
    val (newX, newY) = instructions.head match {
      case '^' => (locations.last._1, locations.last._2 + 1)
      case 'v' => (locations.last._1, locations.last._2 - 1)
      case '>' => (locations.last._1 + 1, locations.last._2)
      case '<' => (locations.last._1 - 1, locations.last._2)
    }
    visits(locations ++ List((newX, newY)), instructions.tail)
  }
}

val input = Util.readFullInputFile()

val visitedHouses = visits(List((0, 0)), input).toSet

Util.printSolution(visitedHouses.size)
