package taskPackage;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Step {
    String stepName;

    boolean canRetry;

    boolean canRollback;

    boolean autoRollback;

    Step rollbackStep;
}
