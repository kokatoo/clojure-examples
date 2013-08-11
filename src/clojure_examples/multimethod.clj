(ns clojure-examples.multimethods)

(defn fee-amt [percentage user]
  (float (* 0.01 percentage (:amount user))))

(defn fee-category [user]
  [(:company user) (:type user)])

(derive ::bronze ::normal)
(derive ::silver ::normal)
(derive ::platinum ::vip)
(derive ::gold ::vip)

(defmulti credit-card-fee fee-category)
(defmethod credit-card-fee [:taka ::bronze] [user]
  (fee-amt 0.05 user))
(defmethod credit-card-fee [:taka ::silver] [user]
  (fee-amt 0.06 user))
(defmethod credit-card-fee [:taka ::vip] [user]
  (fee-amt 0.10 user))
(defmethod credit-card-fee [:isetan ::silver] [user]
  (fee-amt 0.07 user))
(defmethod credit-card-fee [:isetan ::vip] [user]
  (fee-amt 0.12 user))
(defmethod credit-card-fee :default [user]
  (fee-amt 0.03 user))

(def user1 {:company :taka :type ::bronze :amount 1000})
(def user2 {:company :taka :type ::gold :amount 500})
(def user3 {:company :isetan :type ::silver :amount 700})

(credit-card-fee user1)
(credit-card-fee user2)
(credit-card-fee user3)
