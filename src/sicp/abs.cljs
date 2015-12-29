(ns sicp.abs
  (:require
   [reagent.core :as r]
   [sicp.chapter1 :as c1])
  (:require-macros
   [devcards.core :as dc :refer [defcard defcard-doc defcard-rg deftest mkdn-pprint-source]]
   [cljs.test :refer [testing is]]))

(enable-console-print!)

;; ABS
(defcard-doc
  "function `abs`"
  (mkdn-pprint-source c1/abs))
(defcard-rg abs
  [:div>pre "abs [-1 0 1] -> " (str (into [] (map c1/abs [-1 0 1])))])
(deftest abs-test
  (testing "should return absolute value for numbers:"
    (is (= (c1/abs 1) 1))
    (is (= (c1/abs 0) 0))
    (is (= (c1/abs -10) 10))))

