package jl.reports.atsservice;

public class ResponsiblePerson {
  private final String name;
  private final String phone;
  private final String email;

  private ResponsiblePerson(ResponsiblePersonBuilder builder) {
    this.name = builder.name;
    this.phone = builder.phone;
    this.email = builder.email;
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
    return "ResponsiblePerson{" +
        "name='" + name + '\'' +
        ", phone='" + phone + '\'' +
        ", email='" + email + '\'' +
        '}';
  }

  public static class ResponsiblePersonBuilder {
    private String name;
    private String phone;
    private String email;

    public static ResponsiblePersonBuilder builder() {
      return new ResponsiblePersonBuilder();
    }

    public ResponsiblePersonBuilder name(String name) {
      this.name = name;
      return this;
    }

    public ResponsiblePersonBuilder phone(String phone) {
      this.phone = phone;
      return this;
    }

    public ResponsiblePersonBuilder email(String email) {
      this.email = email;
      return this;
    }

    public ResponsiblePerson build() {
      return new ResponsiblePerson(this);
    }
  }
}
