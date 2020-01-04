package JobPackage;

public enum JobStatus {
    INIT(0), WAITING(1), RUNNING(2), FINISHED(3);

    private int value;

    private JobStatus(int value) {
        this.value = value;
    }
}
