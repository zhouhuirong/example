package enumTest.commom;

public enum ResourceType {
    BILL_R(1,"应收"),
    BILL_P(2,"应付");

    private int code;
    private String name;
    private ResourceType(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static ResourceType get(int code) {
        for (ResourceType type : values()) {
            if (type.getCode()==code) {
                return type;
            }
        }
        return null;
    }

    public static String getNameByCode(int code) {
        for (ResourceType type : values()) {
            if (type.getCode()==code) {
                return type.name;
            }
        }
        return null;
    }

    /**
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
}
