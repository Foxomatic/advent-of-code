import $file.^.^.Util
import Util._

import scala.annotation.tailrec

@tailrec
def ageLanternFish(lanternFish: List[Int], days: Int): List[Int] = {
  if (days == 0) return lanternFish
  val reducedTime = lanternFish.map(daysUntilReproduction => daysUntilReproduction - 1)
  val newLanternFish: List[Int] = reducedTime.map(daysUntilReproduction =>
    if (daysUntilReproduction == -1) 6 else daysUntilReproduction
  ) ::: List.fill(reducedTime.count(_ == -1))(8)
  ageLanternFish(newLanternFish, days - 1)
}

val input = readFullInputFile().split(',').toList.map(_.toInt)

printSolution(ageLanternFish(input, 80).size)
