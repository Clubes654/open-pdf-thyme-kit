package jl.reports.dto.atsservice;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import java.time.LocalDateTime;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class AtsServiceReportAircraftAssetsDTO {

  private final String make;
  private final String model;
  private final String tailNumber;
  private final String serialNumber;
  private final String registration;
  private final int yearOfManufacture;
  private final LocalDateTime lastMaintenance;
  private final String status;
  private final LocalDateTime maintenanceDue;
  private final String location;
  private final String garageNumber;
  private final int hoursFlown;
  private final Double maintenanceCost;
  private final List<ServiceHistoryDTO> serviceHistory;
  private final ResponsiblePersonDTO responsiblePerson;

  @JsonCreator
  public AtsServiceReportAircraftAssetsDTO(
      @JsonProperty("make") String make,
      @JsonProperty("model") String model,
      @JsonProperty("tailNumber") String tailNumber,
      @JsonProperty("serialNumber") String serialNumber,
      @JsonProperty("registration") String registration,
      @JsonProperty("yearOfManufacture") int yearOfManufacture,
      @JsonDeserialize(using = LocalDateTimeDeserializer.class)
      @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
      @JsonProperty("lastMaintenance") LocalDateTime lastMaintenance,
      @JsonProperty("status") String status,
      @JsonDeserialize(using = LocalDateTimeDeserializer.class)
      @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
      @JsonProperty("maintenanceDue") LocalDateTime maintenanceDue,
      @JsonProperty("location") String location,
      @JsonProperty("garageNumber") String garageNumber,
      @JsonProperty("hoursFlown") int hoursFlown,
      @JsonProperty("maintenanceCost") Double maintenanceCost,
      @JsonProperty("serviceHistory") List<ServiceHistoryDTO> serviceHistory,
      @JsonProperty("responsiblePerson") ResponsiblePersonDTO responsiblePerson) {
    this.make = make;
    this.model = model;
    this.tailNumber = tailNumber;
    this.serialNumber = serialNumber;
    this.registration = registration;
    this.yearOfManufacture = yearOfManufacture;
    this.lastMaintenance = lastMaintenance;
    this.status = status;
    this.maintenanceDue = maintenanceDue;
    this.location = location;
    this.garageNumber = garageNumber;
    this.hoursFlown = hoursFlown;
    this.maintenanceCost = maintenanceCost;
    this.serviceHistory = serviceHistory;
    this.responsiblePerson = responsiblePerson;
  }

  public String getMake() {
    return make;
  }

  public String getModel() {
    return model;
  }

  public String getTailNumber() {
    return tailNumber;
  }

  public String getSerialNumber() {
    return serialNumber;
  }

  public String getRegistration() {
    return registration;
  }

  public int getYearOfManufacture() {
    return yearOfManufacture;
  }

  public LocalDateTime  getLastMaintenance() {
    return lastMaintenance;
  }

  public String getStatus() {
    return status;
  }

  public LocalDateTime  getMaintenanceDue() {
    return maintenanceDue;
  }

  public String getLocation() {
    return location;
  }

  public String getGarageNumber() {
    return garageNumber;
  }

  public int getHoursFlown() {
    return hoursFlown;
  }

  public Double getMaintenanceCost() {
    return maintenanceCost;
  }

  public List<ServiceHistoryDTO> getServiceHistory() {
    return serviceHistory;
  }

  public ResponsiblePersonDTO getResponsiblePerson() {
    return responsiblePerson;
  }

  @Override
  public String toString() {
    return "AtsServiceReportAircraftAssetsDTO{" +
        "make='" + make + '\'' +
        ", model='" + model + '\'' +
        ", tailNumber='" + tailNumber + '\'' +
        ", serialNumber='" + serialNumber + '\'' +
        ", registration='" + registration + '\'' +
        ", yearOfManufacture=" + yearOfManufacture +
        ", lastMaintenance=" + lastMaintenance +
        ", status='" + status + '\'' +
        ", maintenanceDue=" + maintenanceDue +
        ", location='" + location + '\'' +
        ", garageNumber='" + garageNumber + '\'' +
        ", hoursFlown=" + hoursFlown +
        ", maintenanceCost=" + maintenanceCost +
        ", serviceHistory=" + serviceHistory +
        ", responsiblePerson=" + responsiblePerson +
        '}';
  }
}
