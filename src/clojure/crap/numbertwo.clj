(ns crap.numbertwo
  (:gen-class
   :state state
   :init init
   :main false
   :methods [[stomp [] void]
             [realize [String] void]]))

(defn -init []
  "Initializea poop object, with internal state represented by a hash-map"
  [[] (atom {:squished? false})])

(defn squished? ^Boolean [poo]
  "Returns whether the poop has been squished"
  (-> poo .state deref :squished?))

(defn squish! [poo]
  "Builder that squishes the poop"
  (-> poo .state (swap! assoc :squished? true))
  poo)

(defn -stomp
  [this]
  "Stomp on the poop"
  (println
   (if (not (squished? this))
     (do (squish! this)
         "squishhh!")
     "...nothing...")))

(defn -realize
  [this ^String msg]
  "Realize what has happened"
  (println msg))
