package enumTest;


import enumTest.commom.ResourceType;
import enumTest.commom.StatusType;

public class Bill {
    private int id;
    private int billType;
    private int status;
    private ResourceType resourceType;

    public ResourceType getResourceType() {
        return resourceType;
    }

    public void setResourceType(ResourceType resourceType) {
        this.resourceType = resourceType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBillType() {
        return ResourceType.getNameByCode(this.billType);
    }

    public void setBillType(int billType) {
        this.billType = billType;
    }

    public String getStatus() {
        return StatusType.getName(this.status);
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
