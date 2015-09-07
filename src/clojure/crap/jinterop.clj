(ns crap.jinterop)

;;a simple class that extends iterable
(deftype Zoo
  [^int x ^int y]
  Iterable
  (iterator [this]
    (.iterator (range x y))))

;; a simple function
(defn skew [this]
    (+ 3 5 ))


;; an interface?
(defprotocol Talkable (speak [this]))

;; idk
(extend-protocol Talkable
  String
  (speak [s] s)
  Object
  (speak [this]
    (str (-> this class .getName) "s can't talk!")))
