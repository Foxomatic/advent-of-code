import $file.^.^.Util

val input = Util.readInputFileLines()

val dimensions = input.map(dimensionsString => {
  val values = dimensionsString.split("x").map(_.toInt).sorted // So width and height are smallest
  (values.head, values.tail.head, values.tail.tail.head)
})

def ribbonLength(width: Int, height: Int, depth: Int): Int = {
  2 * (width + height) + (width * height * depth) // Width and height of smallest side
}

val totalRibbonLength = dimensions.map(d => ribbonLength(d._1, d._2, d._3)).sum

Util.printSolution(totalRibbonLength)
