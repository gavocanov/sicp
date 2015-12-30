;;;; vim:fdm=marker
(ns sicp.chapter1
  (:require
   [sicp.util :as u]))

;; abs {{{
(defn abs
  "absolute value of 'x'"
  [x]
  (cond
   (< x 0) (- x)
   (zero? x) 0
   (> x 0) x))
(comment
 (u/log "abs -10: " (abs -10)))
;; abs }}}

;; square {{{
(defn square
  "square of 'x'"
  [x]
  (* x x))
(comment
 (u/log "square 5: " (square 5)))
;; square }}}

;; average {{{
(defn average
  "average of 'x' and 'y'"
  [x y]
  (/ (+ x y) 2))
(comment
 (u/log "average (1 2): " (average 1 2)))
;; average }}}

;; sqrt {{{
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
(comment
 (u/log "sqrt 9: " (sqrt 9)))
;; sqrt }}}

;; factorial {{{
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
(comment
 (u/log "fact 6: " (factorial 6)))
;; factorial }}}

;; fib {{{
(defn fib
  "Compute a Fibbonaci sequence"
  [n]
  (letfn [(fib-iter [a b count]
            (if (zero? count)
              b
              (recur (+ a b) a (dec count))))]
    (fib-iter 1 0 n)))
(comment
 (u/log "fib(10): " (fib 10)))
;; fib }}}

;; gcd {{{
(defn gcd
  "Greatest common denominator of 'a' and 'b'"
  [a b]
  (if (zero? b)
    a
    (recur b (rem a b))))
(comment
 (u/log "GCD of 28 and 16: " (gcd 28 16)))
;; gcd }}}

;; divides? {{{
(defn divides?
  "test if reminder of a division of 'a' from 'b' is 0"
  [a b]
  (zero? (rem b a)))
(comment
 (u/log "divides? 2 4: " (divides? 2 4)))
;; }}}

;; smallest-divisor {{{
(defn smallest-divisor
  "return smallest divisor of 'n', that is bigger then 2"
  [n]
  (letfn [(find-divisor
            [n test-divisor]
            (cond
             (> (square test-divisor) n) n
             (divides? test-divisor n) test-divisor
             :else (recur n (inc test-divisor))))]
    (find-divisor n 2)))
(comment
 (u/log "smallest divisor of 321: " (smallest-divisor 321)))
;; }}}

;; prime? {{{
(defn prime?
  "test if 'n' is a prime number"
  [n]
  (= (smallest-divisor n) n))
(comment
 (u/log "prime? 2: " (prime? 2)))
;; prime? }}}
