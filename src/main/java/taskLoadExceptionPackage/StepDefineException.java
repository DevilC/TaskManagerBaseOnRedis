package taskLoadExceptionPackage;

import taskPackage.Step;

public class StepDefineException extends TaskDefineException {
    public StepDefineException(String message){
        super("Step define wrong.Messge: " + message);
    }
}
