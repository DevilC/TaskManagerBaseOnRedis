package JobPackage;

import lombok.Getter;
import lombok.Setter;
import resultPackage.JobResult;
import taskPackage.Task;

@Getter
@Setter
public class JobImpl implements Job{
    String jobID;

    Task task;

    JobResult jobResult;

    Stage executingStage;

    Action executingAction;

    Status jobStatus;

    public void start() {

    }

    public void retry() {

    }

    public void rollback() {

    }
}
