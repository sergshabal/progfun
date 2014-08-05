package patmat

/**
 * Created by Serg on 05.08.14.
 */

import Huffman._

object Main extends App {
  val text = "Hello my little honey."
  val ct = createCodeTree(text.toList)
  val secret = encode(ct)(text.toList)
  println(decode(ct, secret).mkString, text.length * 16, text.length * 8)
  println(decodedSecret.mkString)
  println(secret.mkString)
  println(quickEncode(ct)(text.toList).mkString)
}
