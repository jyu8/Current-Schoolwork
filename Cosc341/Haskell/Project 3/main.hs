import System.Random

count :: (Eq a) => a -> [a] -> Int
count y ys = foldl (\acc x -> if x == y then acc + 1 else acc + 0) 0 ys 

get_last :: [a] -> a
get_last [] = error "can't get last element empty list"
get_last (x:xs) = if length xs == 0
                  then x
                  else get_next_to_last xs

get_next_to_last :: [a] -> a
get_next_to_last [] = error "empty list"
get_next_to_last (x:xs) = if length xs == 1
                          then x
                          else get_next_to_last xs

pick_random :: [a] -> IO a
pick_random [] = error "empty list"
pick_random xs = randomRIO (0, length xs - 1) >>= return . (xs !!)

--choose :: a -> [a] -> [a]
--choose x ys  = if (length ys) == x
--               then ys
--               else pick_random [ys] : choose ys

ackermann :: (Eq a,Num a) => a -> a -> a
ackermann    0 n = n + 1
ackermann    m 0 = ackermann (m - 1) 1
ackermann    m n = ackermann (m - 1)  (ackermann m (n - 1))