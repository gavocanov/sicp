;;;; vim:fdm=marker
(ns sicp.smallest-divisor
  (:require
   [reagent.core :as r]
   [sicp.chapter1 :as c1])
  (:require-macros
   [devcards.core :as dc :refer [defcard defcard-doc defcard-rg deftest mkdn-pprint-source]]
   [cljs.test :refer [testing is]]))

;; SMALLEST-DIVISOR
(defcard-doc
  "function `smalest-divisor`"
  (mkdn-pprint-source c1/smallest-divisor))
(defcard-rg smallest-divisor
  [:div>pre "smallest divisor of 10 -> " (c1/smallest-divisor 10)])
(deftest smallest-divisor-test
  (testing "smallest-divisor of 10 should be 2"
    (is (= (c1/smallest-divisor 10) 2)))
  (testing "smallest-divisor of 15 should be 3"
    (is (= (c1/smallest-divisor 15) 3)))
  (testing "smallest-divisor of 321 should be 3"
    (is (= (c1/smallest-divisor 321) 3))))
