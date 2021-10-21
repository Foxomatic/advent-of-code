import $file.^.^.Util

import scala.annotation.tailrec

@tailrec
def findEnterBasementPosition(
    i: String,
    currentPosition: Int,
    currentLevel: Int
): Int = {
  val newLevel = currentLevel + (i.head match {
    case '(' => 1
    case ')' => -1
  })
  if (newLevel == -1) currentPosition + 1
  else findEnterBasementPosition(i.tail, currentPosition + 1, newLevel)
}

val input = Util.readFullInputFile()

val enterBasementPosition = findEnterBasementPosition(input, 0, 0)

Util.printSolution(enterBasementPosition)
