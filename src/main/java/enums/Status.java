package enums;

import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;
import java.util.EnumSet;

/**
 * @author vons0
 */

public enum Status {


    /**
     * 失败
     */
    FAIL("1", "操作失败"),
    /**
     * 失败
     */
    SUCCESS("0", "操作成功");

    private String code;
    private String description;

    Status(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static void main(String[] args) {
        Status fail = Status.valueOf("FAIL");
        System.out.println(fail);
        Status[] values = Status.values();
        for (Status value : values) {
            System.out.println(value);
        }

        System.out.println("==========");
        Class<Status> statusClass = Status.class;
        Method[] declaredMethods = statusClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod.getName());
        }

        System.out.println("==========");
        TypeVariable<Class<Status>>[] typeParameters = statusClass.getTypeParameters();
        System.out.println(typeParameters.length);
        System.out.println("==========");
        for (Status enumConstant : statusClass.getEnumConstants()) {
            System.out.println(enumConstant);
        }
        System.out.println("--------");
        EnumSet<Status> statuses = EnumSet.noneOf(Status.class);
        statuses.add(FAIL);
        System.out.println(statuses);
    }
}
