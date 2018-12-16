package think;

import java.util.Iterator;

/**
 * @author vons0
 */
public class IteratorFobonacci implements Iterable<Integer> {
    private Integer n;
    private Generator<Integer> generator;

    public IteratorFobonacci(Generator<Integer> generator, Integer count) {
        this.generator = generator;
        this.n = count;
    }

    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            public void remove() {
                throw new UnsupportedOperationException();
            }

            public boolean hasNext() {
                return n > 0;
            }

            public Integer next() {
                n--;
                return generator.next();
            }
        };
    }

    private static class IteratorFobonacciTest {
        private static void test() {
            Fobonacci fobonacci = new Fobonacci();
            IteratorFobonacci integers = new IteratorFobonacci(fobonacci, 18);
            for (Integer integer : integers) {
                System.out.println(integer);
            }
        }
    }

    public static void main(String[] args) {
        IteratorFobonacci.IteratorFobonacciTest.test();
    }
}
