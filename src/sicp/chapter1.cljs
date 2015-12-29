(ns sicp.chapter1
  (:require
   [sicp.util :as u]))

(defn abs
  "absolute value of 'x'"
  [x]
  (cond
   (< x 0) (- x)
   (zero? x) 0
   (> x 0) x))
; (u/log "abs -10: " (abs -10))

(defn square
  "square of 'x'"
  [x]
  (* x x))
; (u/log "square 5: " (square 5))

(defn average
  "average of 'x' and 'y'"
  [x y]
  (/ (+ x y) 2))
; (u/log "average (1 2): " (average 1 2))

(defn sqrt
  "square root of 'x'"
  [x]
  (letfn [(good-enough? [guess]
            (< (abs (- (square guess) x)) 0.001))]
    (letfn [(improve [guess]
              (average guess (/ x guess)))]
      (letfn [(sqrt-iter [guess]
                (if (good-enough? guess)
                  guess
                  (recur (improve guess))))]
        (sqrt-iter 1.0)))))
; (u/log "sqrt 9: " (sqrt 9))

(defn factorial
  "Factorial of the given number 'n'"
  [n]
  (letfn [(fact-iter [product counter max-count]
            (if (> counter max-count)
              product
              (recur (* counter product)
                     (inc counter)
                     max-count)))]
    (fact-iter 1 1 n)))
; (u/log "fact 6: " (factorial 6))

(defn fib
  "Compute a Fibbonaci sequence"
  [n]
  (letfn [(fib-iter [a b count]
            (if (zero? count)
              b
              (recur (+ a b) a (dec count))))]
    (fib-iter 1 0 n)))
; (u/log "fib(10): " (fib 10))

(defn gcd
  "Greatest common denominator of 'a' and 'b'"
  [a b]
  (if (zero? b)
    a
    (recur b (rem a b))))
(u/log "GCD of 28 and 16: " (gcd 28 16))

