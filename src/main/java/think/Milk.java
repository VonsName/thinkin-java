package think;

/**
 * @author vons0
 */
public class Milk extends Dector {

    public Milk(Dressing dressing) {
        super(dressing);
    }

    @Override
    public void cof() {
        System.out.println("加入牛奶");
        dressing.cof();
    }
}
