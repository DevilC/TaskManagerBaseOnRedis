package taskPackage;

/**
 * Section类型，对应task里面的initStage、executeStage、finallyStage
 */
public enum SectionType {
    INIT(0), EXECUTE(1), FINALLY(2);

    int value;

    SectionType(int value){
        this.value = value;
    }
}
