import $file.^.^.Util
import Util._

import scala.annotation.tailrec

@tailrec
def drawLines(inputData: List[(Int, Int, Int, Int)], grid: Map[(Int, Int), Int] = Map.empty): Map[(Int, Int), Int] = {
  if (inputData.isEmpty) return grid
  val newGrid = inputData match {
    case (x1, y1, x2, y2) :: _ if y1 == y2 =>
      grid ++ (x1.min(x2) to x2.max(x1)).map(x => (x, y1) -> 1).toMap.map { case (k, v) =>
        k -> (v + grid.getOrElse(k, 0))
      }
    case (x1, y1, x2, y2) :: _ if x1 == x2 =>
      grid ++ (y1.min(y2) to y2.max(y1)).map(y => (x1, y) -> 1).toMap.map { case (k, v) =>
        k -> (v + grid.getOrElse(k, 0))
      }
    case (x1, y1, x2, y2) :: _ if (x1 - x2).abs == (y1 - y2).abs =>
      @tailrec
      def diagonal(x1: Int, y1: Int, x2: Int, y2: Int, g: Map[(Int, Int), Int] = Map.empty): Map[(Int, Int), Int] =
        if (x1 == x2) g ++ Map((x1, y1) -> 1)
        else
          diagonal(x1 + (if (x1 > x2) -1 else 1), y1 + (if (y1 > y2) -1 else 1), x2, y2, g ++ Map((x1, y1) -> 1))

      grid ++ diagonal(x1, y1, x2, y2).map { case (k, v) =>
        k -> (v + grid.getOrElse(k, 0))
      }
    case _ => grid
  }
  drawLines(inputData.tail, newGrid)
}

val input = readInputFileLines()

val inputData: List[(Int, Int, Int, Int)] = input.map(_.split("( -> |,)") match {
  case Array(x1, y1, x2, y2) => (x1.toInt, y1.toInt, x2.toInt, y2.toInt)
})

printSolution(drawLines(inputData).values.count(n => n > 1))
