type BingoBoard = List[List[Option[Int]]]

def getBoardsFromInput(input: List[String]): List[BingoBoard] =
  input
    .filterNot(_.isBlank)
    .grouped(5)
    .toList
    .map(board => board.map(line => line.split(' ').filterNot(_.isBlank).map(_.toIntOption).toList))

def fillNumber(bingoBoards: List[BingoBoard], number: Int) =
  bingoBoards.map(board => board.map(line => line.map(n => if (n.contains(number)) None else n)))

def isBingo(bingoBoard: BingoBoard): Boolean =
  bingoBoard.exists(line => line.forall(_.isEmpty)) || bingoBoard.transpose.exists(column => column.forall(_.isEmpty))

def calculateScore(bingoBoard: BingoBoard, finalNumber: Int): Int =
  bingoBoard.flatten.map {
    case None         => 0
    case Some(number) => number
  }.sum * finalNumber
