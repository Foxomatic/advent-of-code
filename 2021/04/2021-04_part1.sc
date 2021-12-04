import $file.DayFour
import $file.^.^.Util
import DayFour._
import Util._

import scala.annotation.tailrec

@tailrec
def playBingo(bingoBoards: List[BingoBoard], numbers: List[Int]): Int = {
  val filledBoards = fillNumber(bingoBoards, numbers.head)
  filledBoards.find(isBingo) match {
    case None               => playBingo(filledBoards, numbers.tail)
    case Some(winningBoard) => calculateScore(winningBoard, numbers.head)
  }
}

val input                  = readInputFileLines()
val (numbers, bingoBoards) = (input.head.split(',').toList.map(_.toInt), getBoardsFromInput(input.tail))

val winningScore = playBingo(bingoBoards, numbers)
printSolution(winningScore)
