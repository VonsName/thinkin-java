package think;

/**
 * @author vons0
 */
public class Singleton {
    private Singleton() {
    }

    public static Singleton getInstance() {
        return SingleEnum.INSTANCE.getInstance();
    }

    private enum SingleEnum {

        /**
         *
         */
        INSTANCE;
        private Singleton singleton;

        /**
         * 枚举构造器 jvm保证只会调用一次
         */
        SingleEnum() {
            singleton = new Singleton();
            System.out.println("SingleEnum");
        }

        public Singleton getInstance() {
            return singleton;
        }
    }

    public static void main(String[] args) {
        System.out.println(Singleton.getInstance() == Singleton.getInstance());
    }
}
