;;;; vim:fdm=marker
(ns sicp.half-interval-method
  (:require
   [reagent.core :as r]
   [sicp.chapter1 :as c1])
  (:require-macros
   [devcards.core :as dc :refer [defcard defcard-doc defcard-rg deftest mkdn-pprint-source]]
   [cljs.test :refer [testing is]]))

;; half-interval-method
(defcard-doc
  "function `half-interval-method`"
  (mkdn-pprint-source c1/half-interval-method))
(defcard-rg half-interval-method
  [:div>pre "approximate π as the root between 2 and 4 of sin x = 0 -> " (c1/half-interval-method js/Math.sin 2.0 4.0)])
(deftest half-interval-method-test
  (testing "should return π for sin 2.0 4.0 :"
    (is (c1/close-enough? (c1/half-interval-method js/Math.sin 2.0 4.0) js/Math.PI))))
