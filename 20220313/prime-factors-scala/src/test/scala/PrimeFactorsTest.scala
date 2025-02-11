import org.scalatest.funsuite.AnyFunSuite

sealed trait Number {
  def primeFactors: List[Int]
}
class Prime(n: Int) extends Number {
  def primeFactors = n match {
    case 1 => Nil
    case n => n :: Nil
  }
}
class Composite(n: Int) extends Number {
  def primeFactors = {
    val smallestPrimeFactor = Number.smallestPrimeFactor(n);
    smallestPrimeFactor :: Number(n / smallestPrimeFactor).primeFactors
  }
}

object Number {
  def apply(n: Int): Number =
    if (isPrime(n)) new Prime(n)
    else new Composite(n)

  def isPrime(n: Int): Boolean =
    (2 until n).forall(n % _ != 0)

  def smallestPrimeFactor(n: Int): Int =
    (2 until n).find(n % _ == 0).get
}

class PrimeFactorsTest extends AnyFunSuite {
  test("prime factors") {
    assert(Number(1).primeFactors == List())
    assert(Number(2).primeFactors == List(2))
    assert(Number(4).primeFactors == List(2, 2))
    assert(Number(8).primeFactors == List(2, 2, 2))
    assert(Number(12).primeFactors == List(2, 2, 3))
  }
}
