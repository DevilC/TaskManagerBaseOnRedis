package taskLoadExceptionPackage;

import taskPackage.Section;

public class SectionOrderDuplicateException extends SectionDefineException {
    public SectionOrderDuplicateException(Section section, String taskName){
        super("Section order duplicate, taskName: "+ taskName + "; section: " + section);
    }
}
