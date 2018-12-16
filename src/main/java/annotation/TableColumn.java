package annotation;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface TableColumn {

    JdbcType value() default JdbcType.NULL;

    int id() default 0;
}
