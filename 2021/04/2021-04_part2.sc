import $file.DayFour
import $file.^.^.Util
import DayFour._
import Util._

import scala.annotation.tailrec

@tailrec
def playBingo(bingoBoards: List[BingoBoard], numbers: List[Int]): Int = {
  val filledBoards = fillNumber(bingoBoards, numbers.head)
  filledBoards.filterNot(isBingo) match {
    case Nil              => calculateScore(filledBoards.head, numbers.head)
    case unfinishedBoards => playBingo(unfinishedBoards, numbers.tail)
  }
}

val input                  = readInputFileLines()
val (numbers, bingoBoards) = (input.head.split(',').toList.map(_.toInt), getBoardsFromInput(input.tail))

val lastBoardScore = playBingo(bingoBoards, numbers)
printSolution(lastBoardScore)
