package think;

import java.util.*;

/**
 * @author vons0
 */
public class Fobonacci implements Generator<Integer> {

    private Integer count = 0;

    public Integer next() {
        return fib(count++);
    }

    private Integer fib(int n) {
        if (n < 2) {
            return 1;
        }
        return fib(n - 2) + fib(n - 1);
    }

    public <T, I extends T, U> void test1(T t, I i, U u) {
        System.out.println(t);
    }

    public <T> List<T> list(T... args) {
        List<T> result = new ArrayList<T>(Arrays.asList(args));
        return result;
    }

    public static <T>Set<T> union(Collection<T> s,Collection<T> b){
        return null;
    }

    static class GeneraotrTest {
        static void test() {
            Fobonacci gen = new Fobonacci();
            for (int i = 0; i < 18; i++) {
                System.out.println(gen.next());
            }
        }
    }

    public static void main(String[] args) {
        Fobonacci.GeneraotrTest.test();
//        union(EnumSet.copyOf(new ArrayList<Enum>()),EnumSet.copyOf(new ArrayList<Enum>()));
        System.out.println(Arrays.toString(new ArrayList<Integer>().getClass().getTypeParameters()));
        System.out.println(Arrays.toString(new ArrayList<String>().getClass().getTypeParameters()));
    }
}
