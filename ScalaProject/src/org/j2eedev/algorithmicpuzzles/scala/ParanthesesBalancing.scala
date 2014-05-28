package org.j2eedev.algorithmicpuzzles.scala
/**
 * @author Umashankar
 * http://j2eedev.org
 */
object ParanthesesBalancing {

  
  def main(args: Array[String]) {
    println("balance: '(if (zero? x) max (/ 1 x))' is balanced"+balance("(if (zero? x) max (/ 1 x))".toList))
    println("balance: 'I told him ...' is balanced"+balance("I told him (that it's not (yet) done).\n(But he wasn't listening)".toList))
    println("balance: ':-)' is unbalanced"+balance(":-)".toList))
    println("balance: counting is not enough"+balance("())(".toList))
  }
   /**
    * 
    */
  def balance(chars: List[Char]): Boolean = {
    //check if parantheses are balanced
    def isParanthesesbalanced(chars: List[Char], numberOfOpens: Int): Boolean = {
        if (chars.isEmpty) numberOfOpens == 0
            else if (chars.head == '(')
                 isParanthesesbalanced(chars.tail,numberOfOpens+1)
            else if (chars.head == ')')
                 numberOfOpens>0 && isParanthesesbalanced(chars.tail,numberOfOpens-1)
            else isParanthesesbalanced(chars.tail,numberOfOpens)
    }
    //call function
    isParanthesesbalanced(chars,0)
 } 
}