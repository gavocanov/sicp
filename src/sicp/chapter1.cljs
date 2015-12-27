(ns sicp.chapter1)

(enable-console-print!)

(defn abs
  "Return the absolute value of 'x'"
  [x]
  (cond
   (< x 0) (- x)
   (= x 0) 0
   (> x 0) x))
; (js/console.log (abs 10))

