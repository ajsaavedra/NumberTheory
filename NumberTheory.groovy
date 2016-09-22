import groovy.time.*

class NumberTheory
{
  static int[] factorsOf(int n)
  {
    def factorsForN = []

    for (int i = 1; i < n; i++) {
      if (n % i == 0) {
        factorsForN << i
      }
    }

    return factorsForN;
  }

  static int[] perfectNumbersUpTo(int n)
  {
    def perfectNumbers = []

    for (int i = 2; i <= n; i++) {
        if (factorsOf(i).sum() == i) {
          perfectNumbers << i
        }
    }

    return perfectNumbers
  }

  static int[] primesUpTo(int n)
  {
    def primesUpTo = { x -> (1..x).findAll { x % it == 0}.size() == 2 }
    return (1..n).findAll { primesUpTo(it) }.each { it }
  }

  static void main(String[] args)
  {
    println "Perfect Numbers up to 10000:"
    def start = new Date()
    println perfectNumbersUpTo(10000)
    def end = new Date()
    println "Total run time: " + TimeCategory.minus(end, start) + "\n"

    println "Primes up to 20: "
    start = new Date()
    println primesUpTo(20)
    end = new Date() 
    println "Total run time: " + TimeCategory.minus(end, start)
  }
}
