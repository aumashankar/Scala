package org.j2eedev.scala

object ScalaWorksheet {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  var x=5                                         //> x  : Int = 5
  def increase(i:Int)=i+1                         //> increase: (i: Int)Int
  increase(x)                                     //> res0: Int = 6
  
  
  def first2(x: Int, y: => Int)=x                 //> first2: (x: Int, y: => Int)Int
    first2(1,1)                                   //> res1: Int = 1
    
    //def abs(x:Int)=if(x>=0) x else -x
    
    //abs(-2)
    
def loop: Boolean=loop                            //> loop: => Boolean

def and (x: Boolean, y: =>Boolean)=if(x) y else false
                                                  //> and: (x: Boolean, y: => Boolean)Boolean

and(true,true)                                    //> res2: Boolean = true
and(false,loop)                                   //> res3: Boolean = false

def or(x: Boolean, y: =>Boolean)=if(x) true else y//> or: (x: Boolean, y: => Boolean)Boolean

or(true,true)                                     //> res4: Boolean = true
or(true,loop)                                     //> res5: Boolean = true
or(false,true)                                    //> res6: Boolean = true

//Newtons Method
def abs(x: Double)=if (x<0) x else -x             //> abs: (x: Double)Double

def sqrtItr(guess: Double,x: Double): Double=
if(isGoodEnough(guess,x)) guess
else sqrtItr(improve(guess,x),x)                  //> sqrtItr: (guess: Double, x: Double)Double

def isGoodEnough(guess: Double,x: Double)=
	abs(guess * guess - x) < 0.001            //> isGoodEnough: (guess: Double, x: Double)Boolean
def improve(guess: Double,x: Double)=
 (guess + x /guess) / 2                           //> improve: (guess: Double, x: Double)Double

def sqrt(x: Double)=sqrtItr(1.0, x)               //> sqrt: (x: Double)Double

sqrt(2)                                           //> res7: Double = 1.0



//Pascal Triangle
def pascal(c: Int,r: Int): Int =
if(c==r||c==0) 1 else pascal(c-1, r-1)+pascal(c, r-1)
                                                  //> pascal: (c: Int, r: Int)Int
pascal(0, 2)                                      //> res8: Int = 1
pascal(1, 2)                                      //> res9: Int = 2
pascal(1, 3)                                      //> res10: Int = 3
                                                  

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
 }                                                //> balance: (chars: List[Char])Boolean

def str="(if (zero? x) max (/ 1 x))"              //> str: => String
balance(str.toList)                               //> res11: Boolean = true


//Third Excercise
def countChange(money: Int, coins: List[Int]): Int = {
  if(money == 0) 1
  else if (money < 0) 0
  else if (coins.isEmpty) 0
  else {
    countChange(money - coins.head, coins) +
    countChange(money, coins.tail)
  }
}                                                 //> countChange: (money: Int, coins: List[Int])Int
val coins: List[Int] = List(1, 2)                 //> coins  : List[Int] = List(1, 2)
countChange(4, coins)                             //> res12: Int = 3

}