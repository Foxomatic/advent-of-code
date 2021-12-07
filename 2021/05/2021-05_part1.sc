import $file.^.^.Util
import Util._

import scala.annotation.tailrec

@tailrec
def drawLines(inputData: List[(Int, Int, Int, Int)], grid: Map[(Int, Int), Int] = Map.empty): Map[(Int, Int), Int] = {
  inputData match {
    case Nil => grid
    case (x1, y1, x2, y2) :: _ if y1 == y2 =>
      val newGrid = grid ++ (x1.min(x2) to x2.max(x1)).map(x => (x, y1) -> 1).toMap.map { case (k, v) =>
        k -> (v + grid.getOrElse(k, 0))
      }
      drawLines(inputData.tail, newGrid)
    case (x1, y1, x2, y2) :: _ if x1 == x2 =>
      val newGrid = grid ++ (y1.min(y2) to y2.max(y1)).map(y => (x1, y) -> 1).toMap.map { case (k, v) =>
        k -> (v + grid.getOrElse(k, 0))
      }
      drawLines(inputData.tail, newGrid)
    case _ => drawLines(inputData.tail, grid)
  }
}

val input = readInputFileLines()

val inputData: List[(Int, Int, Int, Int)] = input.map(_.split("( -> |,)") match {
  case Array(x1, y1, x2, y2) => (x1.toInt, y1.toInt, x2.toInt, y2.toInt)
})

printSolution(drawLines(inputData).values.count(n => n > 1))
