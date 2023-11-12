package br.com.brendosp.fisiocare.modules.patientrecord.utils;

import br.com.brendosp.fisiocare.modules.patientrecord.entities.enums.Gender;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class GenderEnumConverter implements AttributeConverter<Gender, String> {
  @Override
  public String convertToDatabaseColumn(Gender attribute) {
    return attribute != null ? attribute.getValue() : null;
  }

  @Override
  public Gender convertToEntityAttribute(String dbData) {
    return dbData != null ? Gender.fromValue(dbData) : null;
  }
}
