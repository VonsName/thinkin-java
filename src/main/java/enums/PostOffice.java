package enums;

/**
 * @author vons0
 * 策略模式+责任链模式
 */
public class PostOffice {

    enum MainHandler {
        /**
         *
         */
        GENERAL_DE {
            @Override
            public boolean handler(Mail m) {
                switch (m.getGeneral()) {
                    case YES:
                        System.out.println("getGeneral" + m);
                        return true;
                    default:
                        return false;
                }
            }
        },
        MACHANE_SCAN {
            @Override
            public boolean handler(Mail m) {
                switch (m.getScannab()) {
                    case UNSACNABLE:
                        return false;
                    default:
                        switch (m.getAddress()) {
                            case INCORECT:
                                return false;
                            default:
                                System.out.println("auto");
                                return true;
                        }
                }
            }
        },
        RETURN_SENDER {
            @Override
            public boolean handler(Mail m) {
                switch (m.getReturnAddress()) {
                    case MISSING:
                        return false;
                    default:
                        System.out.println("RETURN_SENDER");
                        return true;
                }
            }
        },
        VISUAL_INSPECTION {
            @Override
            public boolean handler(Mail m) {
                switch (m.getReadable()) {
                    case ILLEGIBLE:
                        return false;
                    default:
                        if (m.getAddress() == Mail.Address.INCORECT) {
                            return false;
                        }
                        System.out.println("VISUAL_INSPECTION");
                        return true;
                }
            }
        };

        public abstract boolean handler(Mail m);
    }

    static void handle(Mail mail) {
        for (MainHandler value : MainHandler.values()) {
            if (value.handler(mail)) {
                return;
            }
        }
        System.out.println("dead");
    }

    public static void main(String[] args) {
        for (Mail mail : Mail.genertor(10)) {
            System.out.println(mail.details());
            handle(mail);
            System.out.println("*******");
        }
    }
}
