import $file.^.^.Util
import Util._

import scala.annotation.tailrec

@tailrec
def filterForCommon(binaryNumbers: List[String], index: Int = 0)(leastCommon: Boolean = false): String = {
  def countForIndex(char: Char) = binaryNumbers.map(_.charAt(index)).count(_ == char)
  def swap(bit: Char) = bit match {
    case '1' => '0'
    case '0' => '1'
  }
  binaryNumbers match {
    case lastNumber :: Nil => lastNumber
    case _ =>
      val mostCommon = if (countForIndex('1') >= countForIndex('0')) '1' else '0'
      val filter = if(leastCommon) swap(mostCommon) else mostCommon
      filterForCommon(binaryNumbers.filter(_.charAt(index) == filter), index + 1)(leastCommon)
  }
}

val input = readInputFileLines()
val oxygen = filterForCommon(input)()
val co2 = filterForCommon(input)(leastCommon = true)

printSolution(Integer.parseInt(oxygen, 2) * Integer.parseInt(co2, 2))