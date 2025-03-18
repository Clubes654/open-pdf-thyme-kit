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
public final class AtsServiceReportDTO {

  private final String atsContractType;
  private final String contractId;

  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
  private final LocalDateTime begins;

  @JsonDeserialize(using = LocalDateTimeDeserializer.class)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
  private final LocalDateTime ends;

  private final AtsServiceReportServiceProviderDTO serviceProvider;
  private final AtsServiceReportAircraftOwnerDTO aircraftOwner;
  private final AtsServiceReportContactPersonDTO contactPerson;
  private final List<AtsServiceReportAircraftAssetsDTO> aircraftAssets;
  private final Double realizedCosts;

  @JsonCreator
  public AtsServiceReportDTO(
      @JsonProperty("aviationContractType") String atsContractType,
      @JsonProperty("contractId") String contractId,
      @JsonProperty("begins") LocalDateTime begins,
      @JsonProperty("ends") LocalDateTime ends,
      @JsonProperty("serviceProvider") AtsServiceReportServiceProviderDTO serviceProvider,
      @JsonProperty("aircraftOwner") AtsServiceReportAircraftOwnerDTO aircraftOwner,
      @JsonProperty("contactPerson") AtsServiceReportContactPersonDTO contactPerson,
      @JsonProperty("aircraftAssets") List<AtsServiceReportAircraftAssetsDTO> aircraftAssets,
      @JsonProperty("realizedCosts") Double realizedCosts) {
    this.atsContractType = atsContractType;
    this.contractId = contractId;
    this.begins = begins;
    this.ends = ends;
    this.serviceProvider = serviceProvider;
    this.aircraftOwner = aircraftOwner;
    this.contactPerson = contactPerson;
    this.aircraftAssets = aircraftAssets;
    this.realizedCosts = realizedCosts;
  }

  public String getAtsContractType() {
    return atsContractType;
  }

  public String getContractId() {
    return contractId;
  }

  public LocalDateTime getBegins() {
    return begins;
  }

  public LocalDateTime getEnds() {
    return ends;
  }

  public AtsServiceReportServiceProviderDTO getServiceProvider() {
    return serviceProvider;
  }

  public AtsServiceReportAircraftOwnerDTO getAircraftOwner() {
    return aircraftOwner;
  }

  public AtsServiceReportContactPersonDTO getContactPerson() {
    return contactPerson;
  }

  public List<AtsServiceReportAircraftAssetsDTO> getAircraftAssets() {
    return aircraftAssets;
  }

  public Double getRealizedCosts() {
    return realizedCosts;
  }

  @Override
  public String toString() {
    return "AtsServiceReportAxDTO{"
        + "atsContractType='"
        + atsContractType
        + '\''
        + ", contractId='"
        + contractId
        + '\''
        + ", begins="
        + begins
        + ", ends="
        + ends
        + ", serviceProvider="
        + serviceProvider
        + ", aircraftOwner="
        + aircraftOwner
        + ", contactPerson="
        + contactPerson
        + ", aircraftAssets="
        + aircraftAssets
        + ", realizedCosts="
        + realizedCosts
        + '}';
  }
}
