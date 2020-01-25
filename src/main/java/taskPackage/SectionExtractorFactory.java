package taskPackage;

public class SectionExtractorFactory {
    static SectionExtractorFactory instance = new SectionExtractorFactory();

    public static SectionExtractorFactory getInstance() {
        return instance;
    }

    /**
     * 根据targetClass的注解定义获取对应场景的sectionExtractor
     * @param className 目标class
     * @return SectionExtractor。分为一个类为一个Section的场景与一个类中有多个Section的场景
     * @throws ClassNotFoundException 若输入的className不存在时抛ClassNotFException异常
     */
    public SectionExtractor getSectionExtractor(String className) throws ClassNotFoundException {
        Class targetClass = Class.forName(className);
        SectionTag sectionTag = (SectionTag) targetClass.getAnnotation(SectionTag.class);
        if(sectionTag != null){
            return new ClassAsSectionExtractor(targetClass);
        } else{
            return new MethodWithSectionExtractor(targetClass);
        }
    }

}
