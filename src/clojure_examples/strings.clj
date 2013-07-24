(ns clojure-examples.string)

;;; Letters
(= "HELLO WORLD" (.toUpperCase "hello world"))
(= "HELLO WORLD" (clojure.string/upper-case "hello world"))
(= "HLOWRLD" (apply str (filter #(Character/isUpperCase  %) "HeLlO, WoRLD!")))

;;; REGEX
(= "ABC" (apply str (re-seq #"[A-Z]+" "bA1B3Ce")))

