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
  [:div>p "abs [-1 0 1] -> " (str (map c1/abs [-1 0 1]))])

(deftest abs-test
  (testing "should return absolute value for numbers:"
    (is (= (c1/abs 1) 1))
    (is (= (c1/abs 0) 0))
    (is (= (c1/abs -10) 10))))

;; remember to run lein figwheel and then browse to
;; http://localhost:3449/cards.html

