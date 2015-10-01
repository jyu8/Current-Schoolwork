-- 2.a.
makeSquares list = [x ^ x | x <- list]
-- 2.b.
makeRoots list = [ x | x <- list, x^x `elem` list ]
-- 2.c.
noVowels st = [ x | x <- st, (elem x "AEIOUaeiou")]
-- 2.d.
get4 = [ [x, y] | x <- [1,2,3,4,5,6], y <- [1,2,3,4,5,6], x + y == 4 ]
-- 2.e.
makeTuples list1 list2 = [ (x, y) | x<-list1 , y <-list2 ]
-- 2.f.
lessThan10 list = [ x  | x <- list, snd x < 10 ]

