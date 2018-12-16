package think;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InterImpl implements Inter1, Inter2 {
    public <T> void test1(T t) {
        System.out.println(t.getClass().getSimpleName());
    }

    public <U> void test2(U t) {
        System.out.println(t.getClass().getSimpleName());
    }

    public static void main(String[] args) {
        InterImpl inter = new InterImpl();
        inter.test1("ss");
        inter.test2(111);
        List<String> strings = Collections.checkedList(new ArrayList<String>(), String.class);
        strings.add("a");
    }
}
