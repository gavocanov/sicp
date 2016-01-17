;;;; vim:fdm=marker
(ns sicp.chapter1
  (:require
   [sicp.util :as u]))

;; abs {{{
(defn abs
  "absolute value of 'x'"
  [x]
  (cond
   (neg? x) (- x)
   (zero? x) 0
   (pos? x) x))
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
  (letfn [(find-divisor [n test-divisor]
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

;; expmod {{{
(defn expmod
  "compute the exponential of a number modulo anothe number"
  [base exp m]
  (cond
   (zero? exp) 1
   (even? exp) (rem (square (expmod base (/ exp 2) m)) m)
   :else (rem (* base (expmod base (dec exp) m)) m)))
(comment
 (u/log "expmod base 4, exp 13, m 497: " (expmod 4 13 497)))
;; expmod }}}

;; fermat-test {{{
(defn fermat-test
  "Fermat test"
  [n]
  (letfn [(try-it [a]
            (= (expmod a n n) a))]
    (try-it (inc (rand-int (dec n))))))
(comment
 (u/log "fermat-test 223: " (fermat-test 223)))
;; fermat-test }}}

;; fast-prime? {{{
(defn fast-prime?
  "Try the fermat test for 'n' 'times' times"
  [n times]
  (cond
   (zero? times) true
   (fermat-test n) (recur n (dec times))
   :else false))
(comment
 (u/log "fast-prime? 401 20: " (fast-prime? 401 20)))
;; fast-prime }}}

;; average-damp {{{
(defn average-damp
  "return a procedure that when applied to a number 'x' produces the average of 'x' and ('f' 'x')"
  [f]
  #(average % (f %)))
(comment
 (u/log "(average-dump square) 10: " ((average-damp square) 10)))
;; average-damp }}}

;; close-enough? {{{
(defn close-enough?
  "test if 'x' and 'y' are close enough (0.001)"
  [x y]
  (< (abs (- x y)) 0.001))
;; close-enough? }}}

;; search {{{
(defn- search-method
  "Used internally by half-internal-method"
  [f neg-point pos-point]
  (let [midpoint (average neg-point pos-point)]
    (if (close-enough? neg-point pos-point)
      midpoint
      (let [test-value (f midpoint)]
        (cond
         (pos? test-value) (recur f neg-point midpoint)
         (neg? test-value) (recur f midpoint pos-point)
         :else midpoint)))))
(comment
 (u/log "test search -10 100: " (search-method js/Math.sin 2.0 4.0)))
;; search }}}

;; half-interval-method {{{
(defn half-interval-method
  "Find root of equation using the half-interval method"
  [f a b]
  (let [a-value (f a)
        b-value (f b)]
    (cond
     (and
      (neg? a-value)
      (pos? b-value))
     (search-method f a b)
     (and
      (neg? b-value)
      (pos? a-value))
     (search-method f b a)
     :else (throw "values are not of opposite signs") )))
(comment
 (u/log "pi as the root between 2 and 4 of sin x = 0 -> " (half-interval-method js/Math.sin 2 4))
 (u/log (half-interval-method #(- (* % % %) (* 2 %) 3)
                              1.0
                              2.0)))
;; half-interval-method }}}
