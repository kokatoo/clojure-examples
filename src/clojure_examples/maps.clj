(ns clojure-examples.maps)

;; merge-with
(= {:a 1 :b 2 :c 3}
   (merge-with into {:a 1} {:b 2 :c 3}))

;; zipmap
(= {\D :diamond \H :heart \C :club \S :spades}
   (zipmap "DHCS" [:diamond :heart :club :spades]))

;; destructuring
;; :keys
(def user {:first-name "Jason" :last-name "Kok"})
(let [{:keys [first-name last-name]} user]
  (println "Hello" first-name last-name))
;; :or
(let [{first :first-name last :last-name age :age :or {age 20}} user]
  (println "Age is", age))




