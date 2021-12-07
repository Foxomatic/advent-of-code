import $file.^.^.Util
import Util._

import scala.annotation.tailrec

@tailrec
def ageLanternFish(lanternFishReproduction: Map[Int, Long], days: Int): Map[Int, Long] = {
  if (days == 0) return lanternFishReproduction
  val reducedTime = lanternFishReproduction.map { case (remainingTime, fish) => (remainingTime - 1, fish) }
  val newLanternFish: Map[Int, Long] = reducedTime.map { case (remainingTime, fish) =>
    if (remainingTime == -1) (6, fish + reducedTime.getOrElse(6, 0L)) else (remainingTime, fish)
  } ++ (if (reducedTime.keys.toList.contains(-1)) Map(8 -> reducedTime(-1)) else Map.empty)
  ageLanternFish(newLanternFish, days - 1)
}

val input: Map[Int, Long] = readFullInputFile().split(',').toList.map(_.toInt).groupMapReduce(identity)(_ => 1L)(_ + _)

printSolution(ageLanternFish(input, 256).values.sum)
