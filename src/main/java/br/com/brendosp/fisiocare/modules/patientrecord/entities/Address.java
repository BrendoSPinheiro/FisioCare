package br.com.brendosp.fisiocare.modules.patientrecord.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Address {

  @Column(name = "zip_code", length = 10, nullable = false)
  private String zipCode;

  @Column(name = "address", length = 100)
  private String location;

  @Column(length = 5)
  private String number;

  @Column(length = 45)
  private String complement;

  @Column(length = 45)
  private String city;

  @Column(length = 2)
  private String state;
}
