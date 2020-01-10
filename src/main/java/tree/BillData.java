package tree;

public class BillData {
    /**
     * 组织编码
     */
    private String corCode;
    /**
     * 客商编码
     */
    private String cusCode;
    /**
     * 来源系统编码
     */
    private String sourceCode;
    /**
     * 1应收，2应付
     */
    private String type;
    private String id;

    public BillData() {
    }

    public BillData(String corCode, String cusCode, String sourceCode, String type, String id) {
        this.corCode = corCode;
        this.cusCode = cusCode;
        this.sourceCode = sourceCode;
        this.type = type;
        this.id = id;
    }

    public String getCorCode() {
        return corCode;
    }

    public void setCorCode(String corCode) {
        this.corCode = corCode;
    }

    public String getCusCode() {
        return cusCode;
    }

    public void setCusCode(String cusCode) {
        this.cusCode = cusCode;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BillData{" +
                "corCode='" + corCode + '\'' +
                ", cusCode='" + cusCode + '\'' +
                ", sourceCode='" + sourceCode + '\'' +
                ", type='" + type + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
