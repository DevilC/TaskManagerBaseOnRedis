package resultPackage;

public class ResultBase implements Result{
    private ResultEnum result;

    private int progress;

    private String message;

    ResultBase(){
        this.result = ResultEnum.WAITING;
        this.progress = 0;
        this.message = "";
    }

    public ResultEnum getResult() {
        return this.result;
    }

    public String getMessage() {
        return this.message;
    }

    public int getProgress() {
        return this.progress;
    }

    public void setResult(ResultEnum result) {
        this.result = result;
    }

    public void updateProgress(int progress) {
        this.progress = progress;
    }
}
