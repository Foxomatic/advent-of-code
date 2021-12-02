import $file.^.^.Util
import Util._

import scala.annotation.tailrec

@tailrec
def countIncreases(measurements: List[Int], increases: Int = 0): Int = {
  measurements match {
    case first :: second :: _ =>
      val newIncreases = if (first < second) increases + 1 else increases
      countIncreases(measurements.tail, newIncreases)
    case _ => increases
  }
}

val input = readInputFileLines().map(_.toInt)

printSolution(countIncreases(input))