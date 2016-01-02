;;;; vim:fdm=marker
(ns sicp.expmod
  (:require
   [reagent.core :as r]
   [sicp.chapter1 :as c1])
  (:require-macros
   [devcards.core :as dc :refer [defcard defcard-doc defcard-rg deftest mkdn-pprint-source]]
   [cljs.test :refer [testing is]]))

;; EXPMOD
(defcard-doc
  "function `expmod`"
  (mkdn-pprint-source c1/expmod))
(defcard-rg expmod
  [:div>pre "expmod (base 4, exp 13, modulo 497) -> " (c1/expmod 4 13 497)])
(deftest abs-test
  (testing "should return 445, based on https://en.wikipedia.org/wiki/Modular_exponentiation"
    (is (= (c1/expmod 4 13 497) 445))))


