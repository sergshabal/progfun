package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    (c,r) match {
      case (0,0) => 1
      case (0,_) => 1
      case (x,y) if x == y => 1
      case (x,y) if x > y => 0
      case (x,y) => pascal(x,y-1) + pascal(x-1,y-1)
    }
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def getOPCL(l: List[Char], c: Int): Boolean = {
      l match {
        case List()  if c == 0 => true
        case List()  if c != 0 => false
        case ')':: _ if c == 0 => false
        case '(':: t => getOPCL(t, c+1)
        case ')':: t => getOPCL(t, c-1)
        case  _ :: t => getOPCL(t, c)
      }
    }
    getOPCL(chars, 0)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    /**
     * remake this exercise by yourself!!!
     */

    def countChange(amount: Int, coins: List[Int]) ={
      val ways = Array.fill(amount + 1)(0)
      ways(0) = 1
      coins.foreach(coin =>
        for(j <- coin to amount)
          ways(j) = ways(j) + ways(j-coin)
      )
      ways(amount)
    }
    countChange(money, coins)
  }
}
