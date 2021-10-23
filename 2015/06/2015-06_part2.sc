import $file.Common
import $file.Common
import $file.^.^.Util

import scala.annotation.tailrec

def executeInstruction(line: String, grid: List[List[Int]]): List[List[Int]] = {
  val ((x1, y1), (x2, y2)) = Common.getCoordinates(line)
  val instruction          = Common.Instructions.fromLine(line)
  grid.zipWithIndex.map {
    case (row, index) if index >= y1 && index <= y2 =>
      row.zipWithIndex.map {
        case (value, index) if index >= x1 && index <= x2 =>
          instruction match {
            case Common.Instructions.TurnOff => if (value == 0) 0 else value - 1
            case Common.Instructions.TurnOn  => value + 1
            case Common.Instructions.Toggle  => value + 2
          }
        case (value, _) => value
      }
    case (row, _) => row
  }
}

@tailrec
def applyInputCumulative(input: List[String], grid: List[List[Int]]): List[List[Int]] = {
  input match {
    case Nil => grid
    case _   => applyInputCumulative(input.tail, executeInstruction(input.head, grid))
  }
}

val grid: List[List[Int]] = List.fill(1000)(List.fill(1000)(0))

val input = Util.readInputFileLines()

Util.printSolution(applyInputCumulative(input, grid).flatten.sum)
