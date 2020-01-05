package JobPackage;

import resultPackage.JobResult;

public interface Job {
    void start();

    void retry();

    void rollback();

    JobResult getJobResult();
}
