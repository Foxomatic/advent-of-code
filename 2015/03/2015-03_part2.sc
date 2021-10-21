import $file.^.^.Util

import scala.annotation.tailrec

val input = Util.readFullInputFile()

@tailrec
def splitInstructions(instructions: String, firstHalf: String, secondHalf: String): (String, String) = {
  if (instructions.isEmpty)
    (firstHalf, secondHalf)
  else if (instructions.length % 2 == 0)
    splitInstructions(instructions.tail, firstHalf + instructions.head, secondHalf)
  else
    splitInstructions(instructions.tail, firstHalf, secondHalf + instructions.head)
}

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
val (santa, robot) = splitInstructions(input, "", "")

val visitedHouses = (visits(List((0, 0)), santa) ++ visits(List((0, 0)), robot)).toSet

Util.printSolution(visitedHouses.size)
