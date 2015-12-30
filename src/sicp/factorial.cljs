;;;; vim:fdm=marker
(ns sicp.factorial
  (:require
   [reagent.core :as r]
   [sicp.chapter1 :as c1])
  (:require-macros
   [devcards.core :as dc :refer [defcard defcard-doc defcard-rg deftest mkdn-pprint-source]]
   [cljs.test :refer [testing is]]))

;; FACTORIAL
(defcard-doc
  "function `factorial`"
  (mkdn-pprint-source c1/factorial))
(defcard-rg factorial
  [:div>pre "factorial 6 -> " (c1/factorial 6)])
(deftest factorial-test
  (testing "factorial of 6 should be 720"
    (is (= (c1/factorial 6) 720))))

