(ns sicp.chapter1
  (:require
   [sicp.util :as u]))

(enable-console-print!)

(defn abs
  "absolute value of 'x'"
  [x]
  (cond
   (< x 0) (- x)
   (= x 0) 0
   (> x 0) x))
(u/log "abs -10: " (abs -10))

(defn square
  "square of 'x'"
  [x]
  (* x x))
(u/log "square 5: " (square 5))

(defn average
  "average of 'x' and 'y'"
  [x y]
  (/ (+ x y) 2))
(u/log "average (1 2): " (average 1 2))

(defn sqrt
  "square root of 'x'"
  [x]
  (defn good-enough?
    [guess]
    (< (abs (- (square guess) x)) 0.001))
  (defn improve
    [guess]
    (average guess (/ x guess)))
  (defn sqrt-iter
    [guess]
    (if (good-enough? guess)
      guess
      (sqrt-iter (improve guess))))
  (sqrt-iter 1.0))
(u/log "sqrt 9: " (sqrt 9))

(defn factorial
  "Factorial of the given number 'n'"
  [n]
  (defn fact-iter
    [product counter max-count]
    (if (> counter max-count)
      product
      (fact-iter (* counter product)
                 (+ counter 1)
                 max-count)))
  (fact-iter 1 1 n))
(u/log "fact 6: " (factorial 6))

(defn fib
  "Compute the sequence of 'n' Fibonacci numbers"
  [n]
  (defn fib-iter
    [a b count]
    (if (= count 0)
      b
      (fib-iter (+ a b) a (- count 1))))
  (fib-iter 1 0 n))
(u/log "fib(10): " (fib 10))
