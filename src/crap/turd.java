import crap.jinterop.Zoo;
import clojure.lang.IFn;
import clojure.lang.RT;
import clojure.lang.Symbol;

class Turd {
    public static void main(String[] a){
        System.out.println("ah");
        Zoo z = new Zoo(1, 4);
        System.out.println("x: " +z.x+ " y: " + z.y);
        for (Object x: z){
        System.out.println("i"+x);
        }
    }
}
