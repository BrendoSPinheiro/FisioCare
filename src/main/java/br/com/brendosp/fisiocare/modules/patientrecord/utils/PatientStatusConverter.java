package br.com.brendosp.fisiocare.modules.patientrecord.utils;

import br.com.brendosp.fisiocare.modules.patientrecord.entities.enums.PatientStatus;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class PatientStatusConverter implements AttributeConverter<PatientStatus, String> {
  @Override
  public String convertToDatabaseColumn(PatientStatus attribute) {
    return attribute != null ? attribute.getValue() : null;
  }

  @Override
  public PatientStatus convertToEntityAttribute(String dbData) {
    return dbData != null ? PatientStatus.fromValue(dbData) : null;
  }
}
