package taskPackage;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Step {
    String stepName;

    String actionTarget;

    String actionMethod;

    boolean canRetry;

    boolean canRollback;

    boolean autoRollback;

    Step rollbackStep;

    @Override
    public String toString(){
        return "{stepName: " + stepName + " ;actionTarget: " + actionTarget + "; actionMethod: "
                + actionMethod + "; canRetry: "+ canRetry + "; canRollback: " + canRollback +
                "; autoRollback: " + autoRollback + "; rollbackStep: " + rollbackStep + "}";
    }
}
