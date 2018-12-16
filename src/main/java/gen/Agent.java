package gen;

import java.lang.instrument.Instrumentation;

public class Agent {

    public static void premain(String args, Instrumentation ins) {
        System.out.printf("Hi:%s", "I'm agent");
//        ins.addTransformer(new MyTransformer());
    }

    public static void premain(String agentArgs) {
        System.out.printf("agentArgs:%s", agentArgs);
    }
}
