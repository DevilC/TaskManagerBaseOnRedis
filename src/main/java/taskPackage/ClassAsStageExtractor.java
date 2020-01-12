package taskPackage;

import taskLoadExceptionPackage.SectionDefineDuplicateException;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class ClassAsStageExtractor extends SectionExtractor {
    Section globalSection;
    public ClassAsStageExtractor(Class targetClass){
        super(targetClass);
        SectionTag tag = (SectionTag) targetClass.getAnnotation(SectionTag.class);
        globalSection = new Section(tag.sectionName(), tag.sectionType());
    }

    @Override
    public Section doExtract() throws SectionDefineDuplicateException {
        Method[] methods = targetClass.getMethods();
        for(Method method: methods){
            Annotation[] annotations = method.getAnnotations();
            checkSectionDefineDuplicate(annotations);

        }
    }

    /**
     * 检查有没有重复定义section，class已经定义了section，方法不可以再定义section
     * @param annotations
     * @throws SectionDefineDuplicateException
     */
    private void checkSectionDefineDuplicate(Annotation[] annotations) throws SectionDefineDuplicateException {
        for(Annotation annotation: annotations) {
            if (annotation.annotationType().equals(SectionTag.class)) {
                SectionTag tag = (SectionTag) annotation;
                throw new SectionDefineDuplicateException(tag.sectionName(), this.targetClass);
            }
        }
    }


}
