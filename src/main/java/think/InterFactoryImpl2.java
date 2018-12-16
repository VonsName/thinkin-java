package think;

public class InterFactoryImpl2 implements InterFactory<Milk> {
    public Milk create() {
        return new Milk(new Coffee());
    }

    public static void main(String[] args) {
        InterFactoryImpl2 impl2 = new InterFactoryImpl2();
        Milk milk = impl2.create();

        InterFactoryImpl1 impl1 = new InterFactoryImpl1();
        Coffee coffee = impl1.create();
    }
}
