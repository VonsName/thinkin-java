package annotation;

import io.User;

import java.lang.reflect.Method;

/**
 * @author vons0
 */
public class AnnotationTest {

    public static void main(String[] args) {
        Class<User> userClass = User.class;
        UserCase userCase = userClass.getAnnotation(UserCase.class);

        Method[] declaredMethods = userClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            UserCase annotation = declaredMethod.getAnnotation(UserCase.class);
            if (null != annotation) {

            }
        }
    }
}
