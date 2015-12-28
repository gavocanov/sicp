(ns sicp.core
  (:require
   [reagent.core :as r]
   [sicp.chapter1 :as c1])
  (:require-macros
   [devcards.core :as dc :refer [defcard defcard-doc defcard-rg deftest mkdn-pprint-source]]
   [cljs.test :refer [testing is]]))

(enable-console-print!)

(defcard-doc
  "function `abs`"
  (mkdn-pprint-source c1/abs))

(defcard-rg abs
  [:div>h4>pre "abs [-1 0 1] -> " (str (into [] (map c1/abs [-1 0 1])))])

(deftest abs-test
  (testing "should return absolute value for numbers:"
    (is (= (c1/abs 1) 1))
    (is (= (c1/abs 0) 0))
    (is (= (c1/abs -10) 10))))

(defcard-doc
  "function `sqrt`"
  (mkdn-pprint-source c1/sqrt))

(defcard-rg sqrt
  [:div>h4>pre "sqrt of 9 -> " (c1/sqrt 9)])

(deftest sqrt-test
  (testing "square root results"
    (is (= (c1/sqrt (c1/square 3000)) 3000))
    (is (< (- (c1/sqrt 9) 3) 0.001))))

(defcard-doc
  "function `factorial`"
  (mkdn-pprint-source c1/factorial))

(defcard-rg factorial
  [:div>h4>pre "factorial 6 -> " (c1/factorial 6)])

(deftest factorial-test
  (testing "factorial"
    (is (= (c1/factorial 6) 720))))

(defcard-doc
  "function `fib`"
  (mkdn-pprint-source c1/fib))

(defcard-rg fib
  [:div>h4>pre "Fib(10) -> " (c1/fib 10)])

(deftest fib-test
  (testing "Fib(10)"
    (is (= (c1/fib 10) 55)))
  (testing "Fib(1)"
    (is (= (c1/fib 1) 1))))

;; remember to run lein figwheel and then browse to
;; http://localhost:3449/cards.html

