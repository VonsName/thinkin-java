package think;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ClassFactory<T> {

    private T x;

    public ClassFactory(Class<T> clazz) throws IllegalAccessException, InstantiationException {
        //        T t = new T(); //compile error
        x = clazz.newInstance();
    }

    public T getX() {
        return x;
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        ClassFactory<Emplyee> factory = new ClassFactory<Emplyee>(Emplyee.class);
        Emplyee x = factory.getX();
        System.out.println(x);
        List<Emplyee> emplyees = Collections.nCopies(5, x);
        emplyees.forEach(System.out::println);
    }
}

/**
 * 创建数组泛型
 *
 * @param <T>
 */
class Emplyee<T> {

    public Emplyee() {
    }

    private T[] x;

    public T[] getX() {
        return x;
    }

    public void setX(T[] x) {
        this.x = x;
    }

    @SuppressWarnings("unchecked")
    public Emplyee(Class<T> type, Integer size) {
        x = (T[]) Array.newInstance(type, size);
    }

    public static void main(String[] args) {
        Emplyee<Integer> integerEmplyee = new Emplyee<Integer>(Integer.class, 5);
        Integer[] x = integerEmplyee.getX();
        x[0] = 6;
        System.out.println(Arrays.toString(x));
        String str="aa ";
        System.out.println(str.strip());
    }
}
