package think;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

public class Mnipulator<T extends Hasf> {

    private T obj;
    private Class<T> clazz;

    public Mnipulator(T obj) {
        this.obj = obj;
    }

    @SuppressWarnings("unchecked")
    public void manipulate() {
        obj.f();
        T[] o = (T[]) Array.newInstance(clazz, 5);
    }

    private class User {
    }

    public static void main(String[] args) {
        Hasf hasf = new Hasf();
//        Mnipulator<Hasf> hasfMnipulator = new Mnipulator<Hasf>(hasf);
//        hasfMnipulator.manipulate();
        Singleton singleton2 = Singleton.getInstance();
        Singleton singleton1 = Singleton.getInstance();
        System.out.println(singleton1 == singleton2);
    }

}

class Hasf {
    public void f() {
        System.out.println("hasf");
    }

    public static void main(String[] args) {
        Hasf hasf = new Hasf();
        Mnipulator<Hasf> hasfMnipulator = new Mnipulator<Hasf>(hasf);
        Class<?>[] classes = hasfMnipulator.getClass().getClasses();
        for (Class<?> aClass : classes) {
            System.out.println(aClass);
        }

        int[] ints1 = {1, 2, 3, 4, 5};
        int[] ints2 = new int[5];
        System.arraycopy(ints1, 0, ints2, 0, ints2.length);
        System.out.println(Arrays.toString(ints2));
        System.out.println(Arrays.equals(ints1, ints2));
        System.out.println(Arrays.binarySearch(ints1, 2));
        int[] ints3 = new int[6];
        Arrays.fill(ints3, 13);
        System.out.println(Arrays.toString(ints3));
        Integer[] integers = {1, 2, 3};
        Arrays.sort(integers, new ReverseOrderCom());
        System.out.println(Arrays.toString(integers));
    }
}
