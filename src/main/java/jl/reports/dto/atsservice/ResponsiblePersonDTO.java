package jl.reports.dto.atsservice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class ResponsiblePersonDTO {

  private final String name;
  private final String phone;
  private final String email;

  @JsonCreator
  public ResponsiblePersonDTO(
      @JsonProperty("name") String name,
      @JsonProperty("phone") String phone,
      @JsonProperty("email") String email) {
    this.name = name;
    this.phone = phone;
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public String getPhone() {
    return phone;
  }

  public String getEmail() {
    return email;
  }

  @Override
  public String toString() {
    return "ResponsiblePersonDTO{" +
        "name='" + name + '\'' +
        ", phone='" + phone + '\'' +
        ", email='" + email + '\'' +
        '}';
  }
}
