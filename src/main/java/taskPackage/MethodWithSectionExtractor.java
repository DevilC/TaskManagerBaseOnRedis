package taskPackage;

import taskLoadExceptionPackage.AnnotationRepeatDefineException;
import taskLoadExceptionPackage.RollbackStepNotFoundException;
import taskLoadExceptionPackage.SectionDefineDuplicateException;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MethodWithSectionExtractor extends SectionExtractor {
    MethodWithSectionExtractor(Class targetClass){
        super(targetClass);
    }
    @Override
    public List<Section> doExtract() throws AnnotationRepeatDefineException {
        Map<Section, List<Step>> sectionStepMap = new HashMap<>();
        Method[] methods = targetClass.getMethods();
        for(Method method: methods){
            SectionTag methodSectionTag = checkAnnotationRepeatOnMethodAndGet(SectionTag.class, method);
            if(methodSectionTag != null){
                StepTag methodStepTag = checkAnnotationRepeatOnMethodAndGet(StepTag.class, method);
                if(methodStepTag != null){
                    Section section = new Section(methodSectionTag.sectionName(), methodSectionTag.sectionType(), methodSectionTag.order());
                    if(methodStepTag.rollbackStepName() != ""){
                        Step step = new Step(methodStepTag, targetClass, method);
                        if(!sectionStepMap.containsKey(section)){
                            List<Step> stepList = new ArrayList<>();
                            section.setSteps(stepList);
                            sectionStepMap.put(section, stepList);
                        }
                        sectionStepMap.get(section).add(step);
                    }
                }
            }
        }
        List<Section> sectionList = new ArrayList<>(sectionStepMap.keySet());
        for(Section section: sectionList){
            section.setSteps(section.getSteps().stream().sorted((item1, item2) -> {
                return (item1.order - item2.order);
            }).collect(Collectors.toList()));
        }
        return sectionList.stream().sorted((item1, item2) -> {
            return (item1.order - item2.order);
        }).collect(Collectors.toList());
    }

    /**
     * 检查step指定的rollbackStep是否由定义,rollbackStep与step必须在同一个class中
     * @param sectionList targetClass的所有section
     * @throws AnnotationRepeatDefineException 注解定义重复异常
     * @throws RollbackStepNotFoundException 没找到回退step异常
     */
    private void checkAndSetRollBackStep(List<Section> sectionList) throws AnnotationRepeatDefineException, RollbackStepNotFoundException {
        Method[] methods = targetClass.getMethods();
        for(Section section: sectionList) {
            List<Step> stepList = section.getSteps();
            for(Step step: stepList) {
                if(step.rollbackStepName != null && step.rollbackStepName != ""){
                    step.setCanRollback(true);
                    boolean isFound = false;
                    for (Method method : methods) {
                        StepTag methodStepTag = checkAnnotationRepeatOnMethodAndGet(StepTag.class, method);
                        if (methodStepTag != null && methodStepTag.stepName().equals(step.rollbackStepName)){
                            isFound = true;
                            step.setRollbackStep(new Step(methodStepTag, targetClass, method));
                            break;
                        }
                    }
                    if(!isFound){
                        throw new RollbackStepNotFoundException(step);
                    }
                } else{
                    step.setCanRollback(false);
                }
            }
        }
    }
}
