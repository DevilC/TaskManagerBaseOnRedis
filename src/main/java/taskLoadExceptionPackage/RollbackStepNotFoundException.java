package taskLoadExceptionPackage;

import taskPackage.Step;

public class RollbackStepNotFoundException extends StepDefineException {
    public RollbackStepNotFoundException(Step step){
        super("The rollback step not find for step: " + step);
    }
}
