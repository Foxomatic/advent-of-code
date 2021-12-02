import $file.^.^.Util
import Util._

import scala.annotation.tailrec

def parseLine(line: String) = line.split(' ') match { case Array(direction, count) => (direction, count.toInt) }

@tailrec
def pilotSubmarine(
    instructions: List[(String, Int)],
    aim: Int = 0,
    horizontalPosition: Int = 0,
    depth: Int = 0
): (Int, Int) = {
  instructions match {
    case head :: tail =>
      head match {
        case ("forward", count) => pilotSubmarine(tail, aim, horizontalPosition + count, depth + aim * count)
        case ("down", count)    => pilotSubmarine(tail, aim + count, horizontalPosition, depth)
        case ("up", count)      => pilotSubmarine(tail, aim - count, horizontalPosition, depth)
      }
    case Nil => (horizontalPosition, depth)
  }
}

val input = readInputFileLines().map(parseLine)

val (horizontalPosition, depth) = pilotSubmarine(input)

printSolution(horizontalPosition * depth)
