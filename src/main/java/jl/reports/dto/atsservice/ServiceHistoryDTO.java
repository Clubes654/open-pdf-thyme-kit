package jl.reports.dto.atsservice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class ServiceHistoryDTO {

  private final LocalDateTime date;
  private final String type;
  private final Double cost;

  @JsonCreator
  public ServiceHistoryDTO(
      @JsonDeserialize(using = LocalDateTimeDeserializer.class)
      @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
      @JsonProperty("date") LocalDateTime date,
      @JsonProperty("type") String type,
      @JsonProperty("cost") Double cost) {
    this.date = date;
    this.type = type;
    this.cost = cost;
  }

  public LocalDateTime getDate() {
    return date;
  }

  public String getType() {
    return type;
  }

  public Double getCost() {
    return cost;
  }

  @Override
  public String toString() {
    return "ServiceHistoryDTO{" +
        "date=" + date +
        ", type='" + type + '\'' +
        ", cost=" + cost +
        '}';
  }
}
