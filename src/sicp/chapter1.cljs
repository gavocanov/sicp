(ns sicp.chapter1)

(enable-console-print!)

(defn abs
  "absolute value of 'x'"
  [x]
  (cond
   (< x 0) (- x)
   (= x 0) 0
   (> x 0) x))

(defn square
  "square of 'x'"
  [x]
  (* x x))

(defn average
  "average of 'x' and 'y'"
  [x y]
  (/ (+ x y) 2))

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

