import System.Random

count :: (Eq a) => a -> [a] -> Int
count y ys = foldl (\acc x -> if x == y then acc + 1 else acc + 0) 0 ys   
--folds or add 1 for every element in list


get_last :: [a] -> a
get_last [] = error "can't get last element empty list"
get_last (x:xs) = if length xs == 0
                  then x
                  else get_ xs
--recursively calls itself until the length of the list has been traveled

get_next_to_last :: [a] -> a
get_next_to_last [] = error "empty list"
get_next_to_last (x:xs) = if length xs == 1
                          then x
                          else get_next_to_last xs
--recursively calls itself until the length of the list = 1

pick_random :: [a] -> IO a
pick_random [] = error "empty list"
pick_random xs = randomRIO (0, length xs - 1) >>= return . (xs !!)
--selects a random element from the list using randomRIO and !!

--choose :: a -> [a] -> [a]
--choose x ys  = if (length ys) == x
--               then ys
--               else pick_random [ys] : choose ys

ackermann :: (Eq a,Num a) => a -> a -> a
ackermann x y 
    | x == 0           = y + 1                 
    | y == 0           = ackermann (x-1) x-1 
    | otherwise        = ackermann (x-1) (ackermann x (y - 1))