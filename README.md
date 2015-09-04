# crap.jinterop

Calling Clojure from java. What you never dared asking.
Everyone in the clojure community says that you can call clojure from java, that it is easy to embed it in your existing project etc etc. But there's never a fucking simple example. Here they are.

##why care:
In the real enterprisey planet, you are stuck with java 6, maybe java5, and you want to use a decent language under the hood. But your (pri)mates still need to instantiate a MTFKBLHTTPCLIENT... and so on.


## One : my first class. In clojure. And use it from java.
open `src/crap/FootOnCrap.java` and `src/crap/crap.clj`; This is the "hello world" example. As you might have figured I don't really lke java,so I've named it FootOnCrap. note how the namespace get imported in the java file. This is some of the most complex stuff to get right if, like me, you don't know what the hell the JVM wants from your file structure.
When you are done admiring the simplicity of those two, compile with
```
lein uberjar
```
this will compile the clojure.
follow with
```
javac -cp "src/crap:target/crap.jinterop-0.1.0-SNAPSHOT-standalone.jar"   src/crap/FootOnCrap.java

```
and finally execute the java class with

```
java -cp "src/crap/:target/crap.jinterop-0.1.0-SNAPSHOT-standalone.jar"  FootOnCrap
```

I've not told you a secret: one of the reasons it works, is that I've specified `:uberjar {:aot :all}`.

## Two: cool, but now how I get to define a method on the crap?
I have no clue. So we take another approach: `gen-class`.
