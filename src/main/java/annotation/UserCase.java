package annotation;


import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface UserCase {

    String name() default "";

    int id() default -1;

}
