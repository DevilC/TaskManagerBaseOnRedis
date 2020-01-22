package taskLoadExceptionPackage;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationRepeatDefineException extends Exception{
    public AnnotationRepeatDefineException(Method method){
        super("It's not support define section on class both on the method or define more than one section on one target.Method: " + method.getName());
    }
}
