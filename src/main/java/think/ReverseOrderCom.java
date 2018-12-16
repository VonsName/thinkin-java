package think;

import java.util.Comparator;

public class ReverseOrderCom implements Comparator<Integer> {
    public int compare(Integer o1, Integer o2) {
        return o2.compareTo(o1);
    }
}
