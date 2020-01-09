package taskLoadExceptionPackage;

import taskPackage.Step;

public class StepDuplicateException extends StepDefineException {
    public StepDuplicateException(Step step, String taskName){
        super("Stepname duplicate. taskName: " + taskName + "; Step: " + step.toString());
    }
}
