(defproject crap.jinterop "0.1.0-SNAPSHOT"
  :description "A practice clojure library demonstrating java interop"
  :url "https://github.com/deddu/jinterop"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [prismatic/schema "1.0.1"]]
  :min-lein-version "2.0.0"
  :source-paths ["src/clojure"]
  :aot :all
  :uberjar {:aot :all}
  )
