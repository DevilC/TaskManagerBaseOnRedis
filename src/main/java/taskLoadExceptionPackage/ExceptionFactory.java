package taskLoadExceptionPackage;

import taskPackage.Section;
import taskPackage.StepTag;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class ExceptionFactory {
    /**
     * 一个方法只能被一个step定义
     * @param method 目标方法
     * @throws MethodAnnotationDefineExceedMax 抛异常
     */
    public static void requireOnlyOneStepOnMethod(Method method) throws MethodAnnotationDefineExceedMax {
        Annotation annotations[] = method.getAnnotations();
        checkTargetTagMaxNum(StepTag.class, method, 1);
    }

    /**
     * 一个方法只能被一个section定义
     * @param method 目标方法
     * @throws MethodAnnotationDefineExceedMax 抛异常
     */
    public static void requireOnlyOneSectionOnMethod(Method method) throws MethodAnnotationDefineExceedMax {
        Annotation annotations[] = method.getAnnotations();
        checkTargetTagMaxNum(Section.class, method, 1);
    }

    /**
     * 检查目标tag是否在annotations[]中超过规定的count值
     * @param targetTag 目标tag类型
     * @param method 待检测方法
     * @param max 目标最高数量
     */
    public static void checkTargetTagMaxNum(Class targetTag, Method method, int max) throws MethodAnnotationDefineExceedMax {
        int count = 0;
        Annotation annotations[] = method.getAnnotations();
        for(Annotation annotation: annotations){
            if(annotation.annotationType().equals(targetTag)){
                count ++;
                if(count > max){
                    throw new MethodAnnotationDefineExceedMax(targetTag, max, method);
                }
            }
        }

    }
}
