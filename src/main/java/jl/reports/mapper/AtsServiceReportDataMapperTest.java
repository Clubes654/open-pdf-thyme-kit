package jl.reports.mapper;

import java.util.function.Function;
import java.util.stream.Collectors;
import jl.reports.atsservice.AtsServiceReportAircraftAssetsData;
import jl.reports.atsservice.AtsServiceReportData;
import jl.reports.atsservice.AtsServiceReportData.AtsServiceReportDataBuilder;
import jl.reports.atsservice.ResponsiblePerson;
import jl.reports.atsservice.ServiceHistory;
import jl.reports.common.PdfBasicInfoReportData;
import jl.reports.common.PdfBasicInfoReportData.PdfBasicInfoReportDataBuilder;
import jl.reports.dto.atsservice.AtsServiceReportAircraftAssetsDTO;
import jl.reports.dto.atsservice.AtsServiceReportAircraftOwnerDTO;
import jl.reports.dto.atsservice.AtsServiceReportDTO;
import jl.reports.dto.atsservice.AtsServiceReportContactPersonDTO;
import jl.reports.dto.atsservice.AtsServiceReportServiceProviderDTO;

public class AtsServiceReportDataMapperTest {

  public static final Function<AtsServiceReportAircraftOwnerDTO, PdfBasicInfoReportData>
      TO_AIRCRAFT_OWNER = aircraftOwnerAxDTO -> PdfBasicInfoReportDataBuilder.builder()
      .accountName(aircraftOwnerAxDTO.getAccountName())
      .customerId(aircraftOwnerAxDTO.getCustomerId())
      .address(aircraftOwnerAxDTO.getAddress())
      .phoneNumber(aircraftOwnerAxDTO.getPhoneNumber())
      .vatId(aircraftOwnerAxDTO.getVatId())
      .build();

  public static final Function<AtsServiceReportContactPersonDTO, PdfBasicInfoReportData>
      TO_CONTACT_PERSON = contactPersonAxDTO ->
      contactPersonAxDTO == null ? null :
          PdfBasicInfoReportDataBuilder.builder()
              .name(contactPersonAxDTO.getName())
              .address(contactPersonAxDTO.getAddress())
              .phoneNumber(contactPersonAxDTO.getPhoneNumber())
              .email(contactPersonAxDTO.getEmail())
              .build();

  public static final Function<AtsServiceReportServiceProviderDTO, PdfBasicInfoReportData>
      TO_SERVICE_PROVIDER = serviceProviderAxDTO -> PdfBasicInfoReportDataBuilder.builder()
      .name(serviceProviderAxDTO.getName())
      .address(serviceProviderAxDTO.getAddress())
      .phoneNumber(serviceProviderAxDTO.getPhoneNumber())
      .companyId(serviceProviderAxDTO.getOrganizationId())
      .vatId(serviceProviderAxDTO.getVatId())
      .homeLocation(serviceProviderAxDTO.getHomeLocation())
      .build();

  public static final Function<AtsServiceReportAircraftAssetsDTO, AtsServiceReportAircraftAssetsData>
      TO_AIRCRAFT_ASSETS = aircraftAssetsDTO -> AtsServiceReportAircraftAssetsData.AtsServiceReportAircraftAssetsDataBuilder.builder()
      .make(aircraftAssetsDTO.getMake())
      .model(aircraftAssetsDTO.getModel())
      .tailNumber(aircraftAssetsDTO.getTailNumber())
      .serialNumber(aircraftAssetsDTO.getSerialNumber())
      .registration(aircraftAssetsDTO.getRegistration())
      .yearOfManufacture(aircraftAssetsDTO.getYearOfManufacture())
      .lastMaintenance(aircraftAssetsDTO.getLastMaintenance())
      .status(aircraftAssetsDTO.getStatus())
      .maintenanceDue(aircraftAssetsDTO.getMaintenanceDue())
      .location(aircraftAssetsDTO.getLocation())
      .garageNumber(aircraftAssetsDTO.getGarageNumber())
      .hoursFlown(aircraftAssetsDTO.getHoursFlown())
      .serviceHistory(aircraftAssetsDTO.getServiceHistory() == null ? null :
          aircraftAssetsDTO.getServiceHistory().stream()
              .map(serviceDTO -> ServiceHistory.ServiceHistoryBuilder.builder()
                  .date(serviceDTO.getDate())
                  .type(serviceDTO.getType())
                  .cost(serviceDTO.getCost())
                  .build()
              ).collect(Collectors.toList()))
      .responsiblePerson(aircraftAssetsDTO.getResponsiblePerson() == null ? null :
          ResponsiblePerson.ResponsiblePersonBuilder.builder()
              .name(aircraftAssetsDTO.getResponsiblePerson().getName())
              .phone(aircraftAssetsDTO.getResponsiblePerson().getPhone())
              .email(aircraftAssetsDTO.getResponsiblePerson().getEmail())
              .build()
      )
      .maintenanceCost(aircraftAssetsDTO.getMaintenanceCost())
      .build();


  public AtsServiceReportData apply(AtsServiceReportDTO reportAxDTO) {
    return AtsServiceReportDataBuilder.builder()
        .reportType(reportAxDTO.getAtsContractType())
        .contractId(reportAxDTO.getContractId())
        .ends(reportAxDTO.getEnds())
        .begins(reportAxDTO.getBegins())
        .realizedCosts(reportAxDTO.getRealizedCosts())
        .aircraftOwner(
            TO_AIRCRAFT_OWNER.apply(reportAxDTO.getAircraftOwner()))
        .contactPerson(
            TO_CONTACT_PERSON.apply(reportAxDTO.getContactPerson()))
        .serviceProvider(TO_SERVICE_PROVIDER.apply(
            reportAxDTO.getServiceProvider()))
        .aircraftAssets(
            reportAxDTO.getAircraftAssets().stream().map(TO_AIRCRAFT_ASSETS)
                .collect(Collectors.toList()))
        .build();
  }
}