package taskPackage;

import taskLoadExceptionPackage.SectionDefineDuplicateException;

public abstract class SectionExtractor {
    Class targetClass;

    public SectionExtractor(Class targetClass){
        this.targetClass = targetClass;
    }

    public abstract Section doExtract() throws SectionDefineDuplicateException;
}
