(ns crap.jinterop)

(deftype Zoo
  [^int x ^int y]
  Iterable
  (iterator [this]
    (.iterator (range x y))))

(defn skew [this]
    (+ 3 5 ))
