import $file.^.^.Util

import scala.annotation.tailrec

def isNiceWord(word: String): Boolean = {
  @tailrec
  def letterRepeats(word: String): Boolean = {
    if (word.length == 2) false
    else if (word.head == word.tail.tail.head) true
    else letterRepeats(word.tail)
  }

  @tailrec
  def pairTwice(word: String): Boolean = {
    if(word.length < 4) false
    else if(word.tail.tail.contains(word.take(2))) true
    else pairTwice(word.tail)
  }
  letterRepeats(word) && pairTwice(word)
}

val input = Util.readInputFileLines()

val numberOfNiceWords = input.count(isNiceWord)

Util.printSolution(numberOfNiceWords)
