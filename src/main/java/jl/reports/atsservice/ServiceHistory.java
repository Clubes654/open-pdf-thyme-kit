package jl.reports.atsservice;

import java.time.LocalDateTime;

public class ServiceHistory {
  private final LocalDateTime date;
  private final String type;
  private final double cost;

  private ServiceHistory(ServiceHistoryBuilder builder) {
    this.date = builder.date;
    this.type = builder.type;
    this.cost = builder.cost;
  }

  public LocalDateTime getDate() {
    return date;
  }

  public String getType() {
    return type;
  }

  public double getCost() {
    return cost;
  }

  @Override
  public String toString() {
    return "ServiceHistory{" +
        "date=" + date +
        ", type='" + type + '\'' +
        ", cost=" + cost +
        '}';
  }

  public static class ServiceHistoryBuilder {
    private LocalDateTime date;
    private String type;
    private double cost;

    public static ServiceHistoryBuilder builder() {
      return new ServiceHistoryBuilder();
    }

    public ServiceHistoryBuilder date(LocalDateTime date) {
      this.date = date;
      return this;
    }

    public ServiceHistoryBuilder type(String type) {
      this.type = type;
      return this;
    }

    public ServiceHistoryBuilder cost(double cost) {
      this.cost = cost;
      return this;
    }

    public ServiceHistory build() {
      return new ServiceHistory(this);
    }
  }
}
