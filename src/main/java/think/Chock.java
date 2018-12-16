package think;

public class Chock  extends Dector{

    public Chock(Dressing dressing) {
        super(dressing);
    }

    @Override
    public void cof() {
        System.out.println("加入巧克力");
        dressing.cof();
    }
}
