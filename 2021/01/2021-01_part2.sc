import $file.^.^.Util
import Util._

import scala.annotation.tailrec

@tailrec
def countIncreases(window: Int, measurements: List[Int], increases: Int = 0): Int = {
  measurements match {
    case enoughMeasurements if enoughMeasurements.size > window =>
      val increased = enoughMeasurements.take(window).sum < enoughMeasurements.tail.take(window).sum
      countIncreases(window, measurements.tail, if (increased) increases + 1 else increases)
    case _ => increases
  }
}

val input = readInputFileLines().map(_.toInt)

printSolution(countIncreases(3, input))
