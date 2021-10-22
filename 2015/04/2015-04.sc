import $file.^.^.Util

import java.security.MessageDigest
import scala.annotation.tailrec

implicit val md5MessageDigest: MessageDigest = MessageDigest.getInstance("md5")

def md5(text: String)(implicit messageDigest: MessageDigest): String = {
  messageDigest.update(text.getBytes)
  val digest = messageDigest.digest()
  digest.map("%02X" format _).mkString
}

@tailrec
def findMatchingNumber(input: String, number: Int, requiredStart: String): Int = {
  val hash = md5(input + number.toString)
  if (hash.toList.take(requiredStart.length) == requiredStart.toList) number
  else findMatchingNumber(input, number + 1, requiredStart)
}

val input = "ckczppom"

println("PART 1:")
val part1Number = findMatchingNumber(input, 1, "00000")
Util.printSolution(part1Number)
println("===========================")
println("PART 2:")
val part2Number = findMatchingNumber(input, 1, "000000")
Util.printSolution(part2Number)
