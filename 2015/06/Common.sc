
object Instructions extends Enumeration {
  type Instruction = Value

  val TurnOff, TurnOn, Toggle, Undefined = Value

  def fromLine(line: String): Instruction = {
    if (line.startsWith("turn off")) TurnOff
    else if (line.startsWith("turn on")) TurnOn
    else if (line.startsWith("toggle")) Toggle
    else Undefined
  }
}

def getCoordinates(line: String): ((Int, Int), (Int, Int)) = {
  def extractCoordinates(coordinates: String): (Int, Int) =
    coordinates.split(",") match { case Array(firstValue, secondValue) => (firstValue.toInt, secondValue.toInt) }
  val removeKeywords = List("turn off ", "turn on ", "toggle ", "through ")
  val strippedLine   = removeKeywords.foldLeft(line) { case (line, keyword) => line.replace(keyword, "") }
  strippedLine.split(" ").map(extractCoordinates) match {
    case Array(firstCoordinates, secondCoordinates) => (firstCoordinates, secondCoordinates)
  }
}