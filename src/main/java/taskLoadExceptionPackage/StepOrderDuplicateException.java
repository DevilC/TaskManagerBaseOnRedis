package taskLoadExceptionPackage;

import taskPackage.Step;

public class StepOrderDuplicateException extends StepDefineException {
    public StepOrderDuplicateException(Step step, String taskName){
        super("Step order duplicate, taskName: " + taskName + "; step: " + step);
    }
}
