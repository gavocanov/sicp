(ns sicp.core
  (:require
   [reagent.core :as r]
   [sicp.chapter1 :as c1])
  (:require-macros
   [devcards.core :as dc :refer [defcard defcard-doc defcard-rg deftest]]
   [cljs.test :refer [testing is]]))

(enable-console-print!)

(defcard-rg abs
  "return absoulte vaule of a number"
  [:div>h4 "abs [-1 0 1] -> " (str (into [] (map c1/abs [-1 0 1])))])

(deftest abs-test
  (testing "should return absolute value for numbers:"
    (is (= (c1/abs 1) 1))
    (is (= (c1/abs 0) 0))
    (is (= (c1/abs -10) 10))))

(defcard-rg sqrt
  "calculate square root of 'x'"
  [:div>h4 "sqrt of 9 -> " (str (c1/sqrt 9))])

(deftest sqrt-test
  (testing "square root results"
    (is (= (c1/sqrt (c1/square 3000)) 3000))
    (is (< (- (c1/sqrt 9) 3) 0.001))))

;; remember to run lein figwheel and then browse to
;; http://localhost:3449/cards.html

