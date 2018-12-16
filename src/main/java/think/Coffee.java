package think;

/**
 * @author vons0
 */
public class Coffee implements Dressing {


    public void cof() {
        System.out.println("普通coffee");
    }

    public static void main(String[] args) {
        Milk milk = new Milk(new Chock(new Coffee()));
        milk.cof();
    }
}
