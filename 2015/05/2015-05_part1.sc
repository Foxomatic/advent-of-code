import $file.^.^.Util

import scala.annotation.tailrec

def isNiceWord(word: String): Boolean = {
  val vowels: List[Char] = List('a', 'e', 'i', 'o', 'u')
  val badStrings         = List("ab", "cd", "pq", "xy")

  @tailrec
  def hasDoubleLetters(word: String): Boolean = {
    if (word.length == 1) false
    else if (word.head == word.tail.head) true
    else hasDoubleLetters(word.tail)
  }

  @tailrec
  def countVowels(word: String, vowelsCount: Int = 0): Int = {
    if (word.isEmpty) return vowelsCount
    val newVowelsCount = if (vowels.contains(word.head)) vowelsCount + 1 else vowelsCount
    countVowels(word.tail, newVowelsCount)
  }

  !badStrings.exists(word.contains(_)) && hasDoubleLetters(word) && countVowels(word) >= 3
}

val input = Util.readInputFileLines()

val numberOfNiceWords = input.count(isNiceWord)

Util.printSolution(numberOfNiceWords)
