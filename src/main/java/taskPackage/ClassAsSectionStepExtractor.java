package taskPackage;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ClassAsSectionStepExtractor {
    Class targetClass;

    ClassAsSectionStepExtractor(Class targetClass) {
        this.targetClass = targetClass;
    }

    public List<Step> doExtract(){
        List<Step> stepList = new ArrayList<>();
        Method[] methods = targetClass.getMethods();
        for(Method method: methods){
            Annotation[] annotations = method.getAnnotations();
            for(Annotation annotation: annotations){
                if(StepTag.class.equals(annotation.annotationType())){
                    StepTag tag = (StepTag) annotation;
                    stepList.add(new Step(tag.stepName(), targetClass, method, tag.canRetry(), tag.canRollback(), tag.order()));
                }
            }
        }
        List<Step> sortedSteps = stepList.stream().sorted((item1, item2) -> {
            return (item1.order - item2.order);
        }).collect(Collectors.toList());
        return sortedSteps;
    }
}
