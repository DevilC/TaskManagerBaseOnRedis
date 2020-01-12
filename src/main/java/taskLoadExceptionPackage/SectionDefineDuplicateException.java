package taskLoadExceptionPackage;

import taskPackage.Section;

public class SectionDefineDuplicateException extends SectionDefineException {
    public SectionDefineDuplicateException(String sectionName, Class targetClass){
        super("It's not support define section on class both on the method.Section: " + sectionName + ", targetClass: " + targetClass);
    }
}
