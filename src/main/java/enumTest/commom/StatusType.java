package enumTest.commom;

public enum StatusType {
    STATUS_S(1,"正常"),
    STATUS_E(2,"作废");
    private int code;
    private String name;

    private StatusType(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getName(int code){
        for (StatusType type:values()) {
            if (code == type.code){
                return type.name;
            }
        }
        return null;
    }
}
