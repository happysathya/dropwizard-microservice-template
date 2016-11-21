package cci.model.od;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Industry {
  private String id = null;

  private String name = null;

  private String parentId = null;

  private List<Object> subIndustries = new ArrayList<Object>();

  public Industry id(String id) {
    this.id = id;
    return this;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Industry name(String name) {
    this.name = name;
    return this;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Industry parentId(String parentId) {
    this.parentId = parentId;
    return this;
  }

  public String getParentId() {
    return parentId;
  }

  public void setParentId(String parentId) {
    this.parentId = parentId;
  }

  public Industry subIndustries(List<Object> subIndustries) {
    this.subIndustries = subIndustries;
    return this;
  }

  public Industry addSubIndustriesItem(Object subIndustriesItem) {
    this.subIndustries.add(subIndustriesItem);
    return this;
  }

  public List<Object> getSubIndustries() {
    return subIndustries;
  }

  public void setSubIndustries(List<Object> subIndustries) {
    this.subIndustries = subIndustries;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Industry industry = (Industry) o;
    return Objects.equals(this.id, industry.id) &&
        Objects.equals(this.name, industry.name) &&
        Objects.equals(this.parentId, industry.parentId) &&
        Objects.equals(this.subIndustries, industry.subIndustries);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, parentId, subIndustries);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Industry {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    parentId: ").append(toIndentedString(parentId)).append("\n");
    sb.append("    subIndustries: ").append(toIndentedString(subIndustries)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
  
}

