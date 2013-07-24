(ns clojure-examples.functions)

;; comp
;; ->
(= ((comp last sort rest reverse) [2 5 4 1 3 6])
   (last (sort (rest (reverse [2 5 4 1 3 6]))))
   (-> [2 5 4 1 3 6] reverse rest sort last))

;; ->>
(= (reduce + (map inc (take 3 (drop 2 [2 5 4 1 3 6]))))
   (->> [2 5 4 1 3 6] (drop 2) (take 3) (map inc) (reduce +)))

;; complement
(= true
   ((complement empty?) [1 2 3]))

;; juxt
(= [\C 13]
   ((juxt first count) "Clojure Rocks"))
