import $file.^.^.Util
import Util._

import scala.annotation.tailrec

@tailrec
def mostCommonBits(binaryNumbers: List[String], bits: List[Char] = Nil): String = {
  if(bits.size == binaryNumbers.head.length) return bits.mkString
  def countForIndex(char: Char) = binaryNumbers.map(_.charAt(bits.size)).count(_ == char)
  mostCommonBits(binaryNumbers, bits :+ (if (countForIndex('1') >= countForIndex('0')) '1' else '0'))
}

val input = readInputFileLines()

val gamma = mostCommonBits(input)
val epsilon = gamma.map {
  case '1' => '0'
  case '0' => '1'
}

printSolution(Integer.parseInt(gamma, 2) * Integer.parseInt(epsilon, 2))
