package cci.model.od;

import org.joda.time.LocalDate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Order {
  private String accountId = null;

  private String brand = null;

  private Double budget = null;

  private List<Contact> contacts = new ArrayList<Contact>();

  private Currency currency = null;

  private LocalDate endDate = null;

  private LocalDate orderExpiryDate = null;

  private String id = null;

  private Industry industry = null;

  private String name = null;

  public enum OrderStatusEnum {
    PENDING("PENDING"),
    
    APPROVED("APPROVED"),
    
    REJECTED("REJECTED");

    private String value;

    OrderStatusEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  private OrderStatusEnum orderStatus = null;

  private Boolean packageOnly = null;

  public enum PreferredBillingMethodEnum {
    ELECTRONIC("Electronic"),
    
    POSTAL("Postal");

    private String value;

    PreferredBillingMethodEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  private PreferredBillingMethodEnum preferredBillingMethod = null;

  private String providerData = null;

  private LocalDate startDate = null;

  public Order accountId(String accountId) {
    this.accountId = accountId;
    return this;
  }

  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  public Order brand(String brand) {
    this.brand = brand;
    return this;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public Order budget(Double budget) {
    this.budget = budget;
    return this;
  }

  public Double getBudget() {
    return budget;
  }

  public void setBudget(Double budget) {
    this.budget = budget;
  }

  public Order contacts(List<Contact> contacts) {
    this.contacts = contacts;
    return this;
  }

  public Order addContactsItem(Contact contactsItem) {
    this.contacts.add(contactsItem);
    return this;
  }

  public List<Contact> getContacts() {
    return contacts;
  }

  public void setContacts(List<Contact> contacts) {
    this.contacts = contacts;
  }

  public Order currency(Currency currency) {
    this.currency = currency;
    return this;
  }

  public Currency getCurrency() {
    return currency;
  }

  public void setCurrency(Currency currency) {
    this.currency = currency;
  }

  public Order endDate(LocalDate endDate) {
    this.endDate = endDate;
    return this;
  }

  public LocalDate getEndDate() {
    return endDate;
  }

  public void setEndDate(LocalDate endDate) {
    this.endDate = endDate;
  }

  public Order orderExpiryDate(LocalDate orderExpiryDate) {
    this.orderExpiryDate = orderExpiryDate;
    return this;
  }

  public LocalDate getOrderExpiryDate() {
    return orderExpiryDate;
  }

  public void setOrderExpiryDate(LocalDate orderExpiryDate) {
    this.orderExpiryDate = orderExpiryDate;
  }

  public Order id(String id) {
    this.id = id;
    return this;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Order industry(Industry industry) {
    this.industry = industry;
    return this;
  }

  public Industry getIndustry() {
    return industry;
  }

  public void setIndustry(Industry industry) {
    this.industry = industry;
  }

  public Order name(String name) {
    this.name = name;
    return this;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Order orderStatus(OrderStatusEnum orderStatus) {
    this.orderStatus = orderStatus;
    return this;
  }

  public OrderStatusEnum getOrderStatus() {
    return orderStatus;
  }

  public void setOrderStatus(OrderStatusEnum orderStatus) {
    this.orderStatus = orderStatus;
  }

  public Order packageOnly(Boolean packageOnly) {
    this.packageOnly = packageOnly;
    return this;
  }

  public Boolean getPackageOnly() {
    return packageOnly;
  }

  public void setPackageOnly(Boolean packageOnly) {
    this.packageOnly = packageOnly;
  }

  public Order preferredBillingMethod(PreferredBillingMethodEnum preferredBillingMethod) {
    this.preferredBillingMethod = preferredBillingMethod;
    return this;
  }

  public PreferredBillingMethodEnum getPreferredBillingMethod() {
    return preferredBillingMethod;
  }

  public void setPreferredBillingMethod(PreferredBillingMethodEnum preferredBillingMethod) {
    this.preferredBillingMethod = preferredBillingMethod;
  }

  public Order providerData(String providerData) {
    this.providerData = providerData;
    return this;
  }

  public String getProviderData() {
    return providerData;
  }

  public void setProviderData(String providerData) {
    this.providerData = providerData;
  }

  public Order startDate(LocalDate startDate) {
    this.startDate = startDate;
    return this;
  }

  public LocalDate getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Order order = (Order) o;
    return Objects.equals(this.accountId, order.accountId) &&
        Objects.equals(this.brand, order.brand) &&
        Objects.equals(this.budget, order.budget) &&
        Objects.equals(this.contacts, order.contacts) &&
        Objects.equals(this.currency, order.currency) &&
        Objects.equals(this.endDate, order.endDate) &&
        Objects.equals(this.orderExpiryDate, order.orderExpiryDate) &&
        Objects.equals(this.id, order.id) &&
        Objects.equals(this.industry, order.industry) &&
        Objects.equals(this.name, order.name) &&
        Objects.equals(this.orderStatus, order.orderStatus) &&
        Objects.equals(this.packageOnly, order.packageOnly) &&
        Objects.equals(this.preferredBillingMethod, order.preferredBillingMethod) &&
        Objects.equals(this.providerData, order.providerData) &&
        Objects.equals(this.startDate, order.startDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountId, brand, budget, contacts, currency, endDate, orderExpiryDate, id, industry, name, orderStatus, packageOnly, preferredBillingMethod, providerData, startDate);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Order {\n");
    
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
    sb.append("    brand: ").append(toIndentedString(brand)).append("\n");
    sb.append("    budget: ").append(toIndentedString(budget)).append("\n");
    sb.append("    contacts: ").append(toIndentedString(contacts)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
    sb.append("    orderExpiryDate: ").append(toIndentedString(orderExpiryDate)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    industry: ").append(toIndentedString(industry)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    orderStatus: ").append(toIndentedString(orderStatus)).append("\n");
    sb.append("    packageOnly: ").append(toIndentedString(packageOnly)).append("\n");
    sb.append("    preferredBillingMethod: ").append(toIndentedString(preferredBillingMethod)).append("\n");
    sb.append("    providerData: ").append(toIndentedString(providerData)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
  
}

