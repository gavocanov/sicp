(ns sicp.gcd
  (:require
   [reagent.core :as r]
   [sicp.chapter1 :as c1])
  (:require-macros
   [devcards.core :as dc :refer [defcard defcard-doc defcard-rg deftest mkdn-pprint-source]]
   [cljs.test :refer [testing is]]))

(enable-console-print!)

;; GCD
(defcard-doc
  "function `gcd`"
  (mkdn-pprint-source c1/gcd))
(defcard-rg gcd
  [:div>pre "GCD(28, 16) -> "(c1/gcd 28 16)])
(deftest gcd-test
  (testing "gcd of 28 and 16 should be 4"
    (is (= (c1/gcd 28 16) 4))))

;; remember to run lein figwheel and then browse to
;; http://localhost:3449/cards.html


