(ns crap.poop
  (:gen-class
   :methods [[stomp [] void]
             [realize [String] void]]))

(defn -stomp
  [this]
  (println "squishhh!"))

(defn -realize
  [this msg]
  (println msg))
