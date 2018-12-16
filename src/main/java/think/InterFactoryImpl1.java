package think;

/**
 * @author vons0
 */
public class InterFactoryImpl1 implements InterFactory<Coffee> {

    public Coffee create() {
        return new Coffee();
    }
}
