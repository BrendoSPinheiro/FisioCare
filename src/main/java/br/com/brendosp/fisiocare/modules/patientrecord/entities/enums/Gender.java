package br.com.brendosp.fisiocare.modules.patientrecord.entities.enums;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Getter
public enum Gender {
  MALE("male"),
  FEMALE("female"),
  NON_BINARY("non_binary"),
  OTHER("other");

  private final String value;

  Gender(String value) {
    this.value = value;
  }

  private static final Map<String, Gender> GENDER_MAP = new HashMap<>();

  static {
    for (Gender gender : values()) {
      GENDER_MAP.put(gender.getValue(), gender);
    }
  }

  public static Gender fromValue(String value) {
    return Optional.ofNullable(GENDER_MAP.get(value))
      .orElseThrow(IllegalArgumentException::new);
  }
}
