;;;; vim:fdm=marker
(ns sicp.fib
  (:require
   [reagent.core :as r]
   [sicp.chapter1 :as c1])
  (:require-macros
   [devcards.core :as dc :refer [defcard defcard-doc defcard-rg deftest mkdn-pprint-source]]
   [cljs.test :refer [testing is]]))

;; FIB
(defcard-doc
  "function `fib`"
  (mkdn-pprint-source c1/fib))
(defcard-rg fib
  [:div>pre "Fib(10) -> " (c1/fib 10)])
(deftest fib-test
  (testing "Fib(10) = 55"
    (is (= (c1/fib 10) 55)))
  (testing "Fib(1) = 1"
    (is (= (c1/fib 1) 1))))

