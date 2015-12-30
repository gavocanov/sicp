;;;; vim:fdm=marker
(ns sicp.util
  (:require
   [clojure.string :as s]))

;; log function {{{
(defn log
  "Log stuff to JavaScript console"
  [& args]
  (js/console.log (s/join " " args)))
;; log function }}}
