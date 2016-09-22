-- Part 1: Perfect Numbers
-- 1) Rewrite factors to use list comprehensions
factors x = [f | f <- [1..x-1], mod x f == 0]

-- 2) Find all the perfect numbers up to n
perfectNumbersUpTo n = [x | x <- [1..n], foldl (+) 0 (factors x) == x]

-- Part 2: Primes
-- 1) Write a function that determines whether a given integer is prime
isPrime :: Integer -> Bool
isPrime n = length (filter(\elem -> (mod n elem) == 0) [1..n]) == 2

-- 2) Write a function that stops as soon as it finds a factor
isPrime2 :: Integer -> Bool
isPrime2 n =
    isPrimeRecur [1..n] n
    where
        isPrimeRecur [] n = True
        isPrimeRecur (x:xs) n
            | (mod n x == 0 && x == 1 || x == n) || (mod n x /= 0) = isPrimeRecur xs n
            | otherwise = False
