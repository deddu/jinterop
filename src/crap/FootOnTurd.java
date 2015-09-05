
import clojure.java.api.Clojure;
import clojure.lang.IFn;

/**
 * Created by deddu on 9/5/15.
 */
public class FootOnTurd {
    public static void main(String[] args) {
        IFn plus = Clojure.var("clojure.core", "+");
        System.out.println(plus.invoke(1, 2));
        IFn map = Clojure.var("clojure.core", "map");
        IFn inc = Clojure.var("clojure.core", "inc");
        System.out.println(map.invoke(inc, Clojure.read("[1 2 3]")));
    }

}
