import $file.^.^.Util

val input = Util.readInputFileLines()

val dimensions = input.map(dimensionsString => {
  val values = dimensionsString.split("x").map(_.toInt).sorted // So width and height are smallest
  (values.head, values.tail.head, values.tail.tail.head)
})

def wrappingSurface(width: Int, height: Int, depth: Int): Int = {
  2 * (width * height + width * depth + height * depth) +
    width * height // Width and height of smallest side
}

val totalWrappingSurface = dimensions.map(d => wrappingSurface(d._1, d._2, d._3)).sum

Util.printSolution(totalWrappingSurface)
