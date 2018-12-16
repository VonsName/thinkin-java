package enums;

import io.User;

import java.text.DateFormat;
import java.util.Date;
import java.util.EnumMap;

/**
 * @author vons0
 */
public class EnumTest {
    public void test(Status status) {
        String message;
        switch (status) {
            case FAIL:
                message = "失败";
                System.out.println(message);
                break;
            case SUCCESS:
                message = "成功";
                System.out.println(message);
                break;
            default:
                message = "未知错误";
                System.out.println(message);
                break;
        }
    }

    public static void main(String[] args) {
        new EnumTest().test(Status.SUCCESS);
        EnumMap<Status, User> statusUserEnumMap = new EnumMap<>(Status.class);
        statusUserEnumMap.put(Status.FAIL, new User());
        statusUserEnumMap.put(Status.SUCCESS, new User());
        System.out.println(statusUserEnumMap);
        String format = DateFormat.getDateInstance(DateFormat.FULL).format(new Date());
        System.out.println(format);
    }
}
