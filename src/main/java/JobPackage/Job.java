package JobPackage;

public interface Job {
    void start();

    void retry();

    void rollback();


}
