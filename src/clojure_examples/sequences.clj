(ns clojure-examples.sequences)

;;; seq in, seq out
;; for
(= '(1 5 9 13 17 21 25 29 33 37)
   (for [x (iterate #(+ 4 %) 0)
         :let [z (inc x)]
         :while (< x 40)]
     z))

;; remove
(= '(7)
   (remove #{1 2 3 4 5 6} #{1 3 5 7}))

;; partition-by
(= "Jason"
   (apply str (map first (partition-by identity "Jaaaasssoooonnn"))))

;; interleave
(= '(:a 1 :b 2 :c 3)
   (interleave '(:a :b :c) '(1 2 3)))

;;; creating a lazy seq
;; tree-seq
(= '(1 2 3 4 5 6)
   (filter (complement sequential?) (tree-seq sequential? identity '((1 2) 3 [4 [5 6]]))))
(= '(:A :B :D :E :C :F)
   (map first (tree-seq next rest '(:A (:B (:D) (:E)) (:C (:F))))))


;;; using a sequence
;; some
(= 6
   (some #{2 7 6} [5 6 7 8]))

;; reductions
(= '(1 3 6 10 15 21 28 36 45 55 66)
   (reductions + (range 1 12)))

