package taskLoadExceptionPackage;

import java.lang.reflect.Method;

public class MethodAnnotationDefineExceedMax extends TaskDefineException {
    public MethodAnnotationDefineExceedMax(Class targetTag, int max, Method method) {
        super(String.format("Method %s not support annotation by tag: %s more than %s times.", method.getName(), targetTag.getName(), max));
    }
}
