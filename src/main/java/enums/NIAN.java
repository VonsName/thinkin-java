package enums;

/**
 * @author vons0
 */

public enum NIAN {

    /**
     *
     */
    SI{
        @Override
        String info() {
            return "心心";
        }
    },
    NIAN{
        @Override
        String info() {
            return "念念";
        }
    };
    abstract String info();

    public static void main(String[] args) {
        String info = NIAN.info();
        System.out.println(info);
    }
}
