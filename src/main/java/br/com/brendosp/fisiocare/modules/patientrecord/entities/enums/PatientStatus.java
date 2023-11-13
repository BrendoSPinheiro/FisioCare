package br.com.brendosp.fisiocare.modules.patientrecord.entities.enums;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Getter
public enum PatientStatus {
  PENDING("pending"),
  IN_TREATMENT("in_treatment"),
  COMPLETED("completed"),
  CANCELLED("cancelled"),
  ON_HOLD("on_hold");

  private final String value;

  PatientStatus(String value) {
    this.value = value;
  }

  private static final Map<String, PatientStatus> PATIENT_STATUS_MAP = new HashMap<>();

  static {
    for (PatientStatus status : values()) {
      PATIENT_STATUS_MAP.put(status.getValue(), status);
    }
  }

  public static PatientStatus fromValue(String value) {
    return Optional.ofNullable(PATIENT_STATUS_MAP.get(value))
      .orElseThrow(IllegalArgumentException::new);
  }
}
