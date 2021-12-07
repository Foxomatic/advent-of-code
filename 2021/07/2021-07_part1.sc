import $file.^.^.Util
import Util._

import scala.annotation.tailrec

@tailrec
def alignCrabs(crabs: List[Int], alignLine: Int, usedFuel: Int = 0): Int = {
  crabs match {
    case position :: remainingCrabs =>
      alignCrabs(remainingCrabs, alignLine, usedFuel + (position - alignLine).abs)
    case Nil => usedFuel
  }
}

val input  = readFullInputFile().split(',').map(_.toInt).sorted
val median = input(input.length / 2)

printSolution(alignCrabs(input.toList, median))
