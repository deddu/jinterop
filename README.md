# crap.jinterop

Calling Clojure from java. What you never dared asking.
Everyone in the clojure community says that you can call clojure from java, that it is easy to embed it in your existing project etc etc. But there's never a fucking simple example. Here they are. 
##tools
lein, javac, java. I know it is possible to go barebones with `(compile)` from the repl, but it is simpler this way. The objective here is to experiment and understand how to create code in clojure that can be used in your legacy java app. Or by your legacy coworkers.

##why care:
In the real enterprisey planet, you are stuck with java 6, maybe java5, and you want to use a decent language under the hood. But your (pri)mates still need to instantiate a MTFKBLHTTPCLIENT and don't want to move on... or Prod has other priorities, such as *for when it rains next tuesday and you're home* and so on.


## One : let's build a simple class. In clojure. And let's use it from java.
below you can find `src/crap/FootOnCrap.java` and `src/crap/crap.clj`; Those compose my "hello world" example. Note how the namespace get imported in the java file. This is some of the most complex stuff to get right if, like me, you don't know what the hell the JVM wants from your file structure. 
here they are for simplicity:

```clojure
;; src/crap/crap.clj
(ns crap.crap)

;;a simple class
(deftype Crap
  [^String consistence ^String smell ^String color])

```
and

```java
//src/crap/FootOnCrap.java
import crap.crap.Crap;

class FootOnCrap {
    public static void main(String[] a){
        System.out.println("ah!");
        Crap z = new Crap("creamy","OMG", "beige");
        System.out.println("I stomped on a "+z.consistence+" "+z.color+" crap! it also smells like " + z.smell + "!!");
        }
}

```
I created both those files in the same directory, because I don't really care about the best practices, I don't know them, and we are playing around. So 
when you are done admiring the simplicity of those two, compile with
```bash
lein uberjar
```
this will compile the clojure.
follow with
```bash
javac -cp "src/crap:target/crap.jinterop-0.1.0-SNAPSHOT-standalone.jar"   src/crap/FootOnCrap.java

```
and finally execute the java class with

```bash
java -cp "src/crap/:target/crap.jinterop-0.1.0-SNAPSHOT-standalone.jar"  FootOnCrap
```
Hurray!!

Few things to observe:

- I've not told you a secret: one of the reasons it works, is that I've specified `:uberjar {:aot :all}` in the `project.clj`. **This is necessary**: Clojure usually compiles his classes at run time, so you need to pass "ahead of time" to the buildtool. You want to have the bytecode available for your java class, so you need to instruct lein!

- We are using the uberjar, as in my opinion it make it simpler. You can alternatively spend some time passing the classes directly in the classpath. (either unzip the jar, or add `:aot [$path]` to your project.clj  ).

- Deftype creates a simple class. The `^String` is clojure *metadata* and is optional. It is called *type* annotation, (i believe under the hood adds a `^{:tag "String"}` metadata) and, if I got it right, it helps: the attributes will otherwise default to Object! Well actually they still are objects. Meh.

- See in the java file how we are accessing the properties on the object: We are accessing directly the instance variables, and not using getters and setters. Probably there's some way to auto-generate those, but I have no clue.

- Also look carefully at the namespace of the clojurefile, how it get translated in the import statement of the java file.


## Two: cool, but now how I get to define a method on the crap?
I have no clue. So we take another approach: `gen-class`.
here's our crap.poop namespace:

```clojure
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
```

And here's our java code:

```java
import crap.poop;

class FootOnPoop {
    public static void main(String[] a){
        poop pp= new poop();
        pp.stomp();
        pp.realize("ohy noy!");
    }
}
```

Again, when you are done admiring the simplicity of those two, compile the clojure with

```bash
lein uberjar
```

follow with

```bash
javac -cp "src/crap:target/crap.jinterop-0.1.0-SNAPSHOT-standalone.jar"   src/crap/FootOnPoop.java
```

and finally execute the java class with

```bash
java -cp "src/crap/:target/crap.jinterop-0.1.0-SNAPSHOT-standalone.jar"  FootOnPoop
```


## Three: interfaces, etc.
see among the files, there's one example. Work In Progress

## References, links and footnotes:
1. Also see [clojure programming](http://shop.oreilly.com/product/0636920013754.do) 
2. [clojure for the brave and true](http://braveclojure.com). 
3. [Stuart Halloway's talk is also great](http://www.infoq.com/presentations/Clojure-Java-Interop)
4. Tutorial on `gen-class` by [Meikel Brandmeyer](http://kotka.de/blog/2010/02/gen-class_how_it_works_and_how_to_use_it.html) 
5. [Discussion of polyglot leiningen projects in the leiningen documentation]
(https://github.com/technomancy/leiningen/blob/master/doc/MIXED_PROJECTS.md)
