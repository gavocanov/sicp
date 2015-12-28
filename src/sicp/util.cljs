(ns sicp.util
  (:require
   [clojure.string :as s]))

(defn log
  "Log stuff to JavaScript console"
  [& args]
  (js/console.log (s/join " " args)))

