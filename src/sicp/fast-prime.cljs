;;;; vim:fdm=marker
(ns sicp.fast-prime
  (:require
   [reagent.core :as r]
   [sicp.chapter1 :as c1])
  (:require-macros
   [devcards.core :as dc :refer [defcard defcard-doc defcard-rg deftest mkdn-pprint-source]]
   [cljs.test :refer [testing is]]))

;; fast-prime?
(defcard-doc
  "function `fast-prime?`"
  (mkdn-pprint-source c1/fast-prime?))
(defcard-rg fast-prime?
  [:div>pre "fast-prime? 593 -> " (str (c1/fast-prime? 593 100))])
(deftest fast-prime?-test
  (testing "should return true for prime numbers (ref. https://en.wikipedia.org/wiki/Prime_number)"
    (is (= (c1/fast-prime? 593 100) true))
    (is (= (c1/fast-prime? 479 100) true))
    (is (= (c1/fast-prime? 594 100) false))))
