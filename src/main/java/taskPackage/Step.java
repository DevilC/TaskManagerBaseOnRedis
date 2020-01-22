package taskPackage;

import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Method;

@Getter
@Setter
public class Step {
    String stepName;

    Class actionTarget;

    Method actionMethod;

    boolean canRetry;

    boolean canRollback;

    boolean autoRollback;

    String rollbackStepName;

    Step rollbackStep;

    int order;

    Step(StepTag stepTag, Class actionTarget, Method actionMethod) {
        this(stepTag.stepName(), actionTarget, actionMethod, stepTag.canRetry(), stepTag.canRollback(), stepTag.order(), stepTag.rollbackStepName());
    }

    Step(String stepName, Class actionTarget, Method actionMethon, boolean canRetry, boolean canRollback, int order, String rollbackStepName) {
        this.stepName = stepName;
        this.actionTarget = actionTarget;
        this.actionMethod = actionMethon;
        this.canRetry = canRetry;
        this.canRollback = canRollback;
        this.order = order;
        this.rollbackStepName = rollbackStepName;
    }

    @Override
    public String toString(){
        return "{stepName: " + stepName + " ;actionTarget: " + actionTarget + "; actionMethod: "
                + actionMethod + "; canRetry: "+ canRetry + "; canRollback: " + canRollback +
                "; autoRollback: " + autoRollback + "; rollbackStep: " + rollbackStep + "}";
    }

    public boolean equals(Object obj){
        if(!(obj instanceof Step)){
            return false;
        }
        Step stepObj = (Step) obj;
        if(stepObj.stepName.equals(this.stepName)){
            return true;
        }
        return false;
    }
}
