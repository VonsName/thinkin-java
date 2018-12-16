package think;

public class MilkGenerator implements Generator<Coffee> {
    public Coffee next() {
        return new Coffee();
    }
}
