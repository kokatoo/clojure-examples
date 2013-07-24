(ns clojure-examples.maps)

;; merge-with
(= {:a 1 :b 2 :c 3}
   (merge-with into {:a 1} {:b 2 :c 3}))

;; zipmap
(= {\D :diamond \H :heart \C :club \S :spades}
   (zipmap "DHCS" [:diamond :heart :club :spades]))


