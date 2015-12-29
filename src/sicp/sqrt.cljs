(ns sicp.sqrt
  (:require
   [reagent.core :as r]
   [sicp.chapter1 :as c1])
  (:require-macros
   [devcards.core :as dc :refer [defcard defcard-doc defcard-rg deftest mkdn-pprint-source]]
   [cljs.test :refer [testing is]]))

(enable-console-print!)

;; SQRT
(defcard-doc
  "function `sqrt`"
  (mkdn-pprint-source c1/sqrt))
(defcard-rg sqrt
  [:div>pre "sqrt of 9 -> " (c1/sqrt 9)])
(deftest sqrt-test
  (testing "sqrt of 3000 should be 3000"
    (is (= (c1/sqrt (c1/square 3000)) 3000)))
  (testing "sqrt of 9 should be ~3, test if it's in the required precission of 0.001"
    (is (< (- (c1/sqrt 9) 3) 0.001))))

