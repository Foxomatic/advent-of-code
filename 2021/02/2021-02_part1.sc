import $file.^.^.Util
import Util._

import scala.annotation.tailrec

def parseLine(line: String) = line.split(' ') match { case Array(direction, count) => (direction, count.toInt) }

@tailrec
def pilotSubmarine(instructions: List[(String, Int)], horizontalPosition: Int = 0, depth: Int = 0): (Int, Int) = {
  instructions match {
    case head :: tail =>
      head match {
        case ("forward", count) => pilotSubmarine(tail, horizontalPosition + count, depth)
        case ("down", count)    => pilotSubmarine(tail, horizontalPosition, depth + count)
        case ("up", count)      => pilotSubmarine(tail, horizontalPosition, depth - count)
      }
    case Nil => (horizontalPosition, depth)
  }
}

val input = readInputFileLines().map(parseLine)

val (horizontalPosition, depth) = pilotSubmarine(input)

printSolution(horizontalPosition * depth)
