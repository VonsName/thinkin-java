package swing;

import io.User;

import java.beans.*;
import java.lang.reflect.Method;

/**
 * @author vons0
 */
public class IntrospectorTest {

    public static void main(String[] args) throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(User.class, Object.class);
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor descriptor : propertyDescriptors) {
            Class<?> propertyType = descriptor.getPropertyType();
            System.out.println(propertyType.getName());
            Method readMethod = descriptor.getReadMethod();
            if (readMethod != null) {
                System.out.println(readMethod.getName());
            }
            Method writeMethod = descriptor.getWriteMethod();
            if (writeMethod != null) {
                System.out.println(writeMethod.getName());
            }
        }

        System.out.println("================");
        MethodDescriptor[] methodDescriptors = beanInfo.getMethodDescriptors();
        for (MethodDescriptor descriptor : methodDescriptors) {
            Method method = descriptor.getMethod();
            if (method != null) {
                System.out.println(method.getName());
            }
            ParameterDescriptor[] parameterDescriptors = descriptor.getParameterDescriptors();
            if (parameterDescriptors != null) {
                for (ParameterDescriptor parameterDescriptor : parameterDescriptors) {
                    if (null != parameterDescriptor) {
                        System.out.println("parameterDescriptor:"+parameterDescriptor.getName());
                    }
                }
            }
        }
        System.out.println("========EventSetDescriptor===========");
        EventSetDescriptor[] eventSetDescriptors = beanInfo.getEventSetDescriptors();
        for (EventSetDescriptor eventSetDescriptor : eventSetDescriptors) {
            Method addListenerMethod = eventSetDescriptor.getAddListenerMethod();
            if (addListenerMethod!=null){
                System.out.println("addListenerMethod=="+addListenerMethod.getName());
            }
        }
    }
}
