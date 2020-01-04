package JobPackage;

public enum ResultEnum {
    SUCCESS(0), FAILED(-1), PARTIALSUCCESS(1), WAITING(999);
    int value;

    private ResultEnum(int value){
        this.value = value;
    };
}
