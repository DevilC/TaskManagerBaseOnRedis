package taskPackage;

public enum ExclusiveType {
    /**
     * 互斥类型，分为三个等级；分别为
     * Global: 全局互斥,只能单独执行这个任务
     * Business: 业务类型互斥，同一个业务类型的任务只能同时执行一个
     * Task: 任务互斥，同一种任务只能同时执行一个
     */
    Global(0), Business(1), Task(2);

    ExclusiveType(int value){
        this.value = value;
    }

    public static ExclusiveType getExclusiveType(String type){
        if("Global".equals(type)){
            return Global;
        } else if("Business".equals(type)){
            return Business;
        } else{
            return Task;
        }
    }

    int value;
}
