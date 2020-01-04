package JobPackage;

public interface Result {
    /**
     * 获取结果
     * @return ResultEnum
     */
    ResultEnum getResult();

    /**
     * 获取详细信息
     * @return String
     */
    String getMessage();

    /**
     * 获取进度
     * @return int
     */
    int getProgress();

    /**
     * 设置Result
     * @param result 目标result
     */
    void setResult(ResultEnum result);

    /**
     * 更新进度
     * @param progress
     */
    void updateProgress(int progress);
}
