package JobPackage;

public enum Status {
    INIT(0), WAITING(1), RUNNING(2), FINISHED(3);

    private int value;

    private Status(int value) {
        this.value = value;
    }
}
