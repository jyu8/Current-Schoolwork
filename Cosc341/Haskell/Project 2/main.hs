--Author:Josh Yu

tail' :: (Ord a) => [a] -> a
tail' [] = error "tail of an empty list"
tail' [x] = x
tail' (x: xs) = tail' xs

product' :: (Num a) => [a] -> a
product' [] = error "product of empty list"
product' [x] = x
product' (x:xs) = x * product' xs

cityBlock (x1,y1) (x2,y2) = (abs(x1 - x2) + abs(y1 - y2))

euclid (x1,y1) (x2,y2) = sqrt ( (x1 - x2) ^ 2 + (y1 - y2) ^2 )

sum'' :: (Num a) => [a] -> [a] -> [a]
sum'' [] _ = []
sum'' (x:xs) (y:ys) = (x+y) : sum'' xs ys

reverse' :: [a] -> [a]  
reverse' [] = []  
reverse' (x:xs) = reverse' xs ++ [x]  

pickIt :: (Ord a) => [a] -> [Bool] -> [a]
pickIt _ []          = []
pickIt [] _          = []
pickIt (x:xs) (y:ys)
    | y == True     = x : pickIt xs ys
    | otherwise     = pickIt xs ys

pack :: [(String,Bool)] -> [(String,Bool)]
pack [] = []
pack [(x,y)] = [(x,y)]
pack ((x,y) : [(xs,ys)])
    | snd(x,y) == True      = (x,y) : pack [(xs,ys)]
    | otherwise             = pack [(xs,ys)]