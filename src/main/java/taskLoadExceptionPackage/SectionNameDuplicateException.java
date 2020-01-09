package taskLoadExceptionPackage;

import taskPackage.Section;

public class SectionNameDuplicateException extends SectionDefineException {
    public SectionNameDuplicateException(Section section, String taskName){
        super("Section name duplicate, taskName: " + taskName + "; section: " + section.toString());
    }
}
