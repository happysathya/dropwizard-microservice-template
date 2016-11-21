package cci.model;

public class CCI_Order {

    private String orderId;
    private String advertiserOrgId;
    private String advertiserOrgName;
    private String brandId;
    private String brandName;
    private String orderStatus;
    private String createdDate;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getAdvertiserOrgId() {
        return advertiserOrgId;
    }

    public void setAdvertiserOrgId(String advertiserOrgId) {
        this.advertiserOrgId = advertiserOrgId;
    }

    public String getAdvertiserOrgName() {
        return advertiserOrgName;
    }

    public void setAdvertiserOrgName(String advertiserOrgName) {
        this.advertiserOrgName = advertiserOrgName;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
}
