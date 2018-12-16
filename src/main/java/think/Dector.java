package think;

/**
 * @author vons0
 */
public class Dector implements Dressing{
    protected Dressing dressing;

    public Dector(Dressing dressing) {
        this.dressing = dressing;
    }

    public void cof() {
        dressing.cof();
    }
}
