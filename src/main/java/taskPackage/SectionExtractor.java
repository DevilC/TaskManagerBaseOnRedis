package taskPackage;

import taskLoadExceptionPackage.AnnotationRepeatDefineException;
import taskLoadExceptionPackage.SectionDefineDuplicateException;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public abstract class SectionExtractor {
    Class targetClass;

    public SectionExtractor(Class targetClass){
        this.targetClass = targetClass;
    }

    public abstract List<Section> doExtract() throws AnnotationRepeatDefineException, SectionDefineDuplicateException;

    /**
     * 判断是否重复定义注解，并返回目标注解list
     * @param T 注解类型
     * @param method 目标方法
     * @param <T> 注解类型
     * @return List<T>
     * @throws AnnotationRepeatDefineException 注解重复定义异常
     */
    public <T extends Annotation> T checkAnnotationRepeatOnMethodAndGet(Class T, Method method) throws AnnotationRepeatDefineException {
        Annotation[] annotations = method.getAnnotations();
        List<T> targetList = new ArrayList<>();
        for(Annotation annotation: annotations){
            if(annotation.annotationType().equals(T)){
                targetList.add((T)annotation);
                if(targetList.size() > 1){
                    throw new AnnotationRepeatDefineException(method);
                }
            }
        }
        if(targetList.size() == 1){
            return targetList.get(0);
        }
        return null;
    }
}
