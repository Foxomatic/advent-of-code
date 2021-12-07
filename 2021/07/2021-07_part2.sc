import $file.^.^.Util
import Util._

import scala.annotation.tailrec

@tailrec
def alignCrabs(crabs: List[Int], alignLine: Int, usedFuel: Long = 0): Long = {
  def cost(distance: Int): Int = if (distance == 0) 0 else distance + cost(distance - 1)
  crabs match {
    case position :: remainingCrabs =>
      alignCrabs(remainingCrabs, alignLine, usedFuel + cost((position - alignLine).abs))
    case Nil => usedFuel
  }
}

val input = readFullInputFile().split(',').map(_.toInt).sorted
val mean  = (input.sum.toFloat / input.length).toInt // approx

printSolution(alignCrabs(input.toList, mean))
