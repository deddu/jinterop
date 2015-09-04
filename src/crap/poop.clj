(ns crap.poop
  (:gen-class
   :methods [[show [] void]
             [showmsg [String] void]]))

(defn -show
  [this]
  (println "prrooooot!"))

(defn -showmsg
  [this msg]
  (println msg))
