;;;; vim:fdm=marker
(ns sicp.fermat-test
  (:require
   [reagent.core :as r]
   [sicp.chapter1 :as c1])
  (:require-macros
   [devcards.core :as dc :refer [defcard defcard-doc defcard-rg deftest mkdn-pprint-source]]
   [cljs.test :refer [testing is]]))

;; fermat-test
(defcard-doc
  "function `fermat-test`"
  (mkdn-pprint-source c1/fermat-test))
(defcard-rg fermat-test
  [:div>pre "fermat-test 2 -> " (str (c1/fermat-test 2))])
(deftest fermat-test-test
  (testing "should return true for primes, false otherwise"
    (is (= (c1/fermat-test 2) true))
    (is (= (c1/fermat-test 4) false))))
