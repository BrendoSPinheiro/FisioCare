package br.com.brendosp.fisiocare.modules.patientrecord.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

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

  public String getZipCode() {
    return zipCode;
  }

  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getComplement() {
    return complement;
  }

  public void setComplement(String complement) {
    this.complement = complement;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;

    if (!(o instanceof Address address)) return false;

    return new EqualsBuilder().append(zipCode, address.zipCode)
      .append(location, address.location)
      .append(number, address.number)
      .append(complement, address.complement)
      .append(city, address.city)
      .append(state, address.state)
      .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37).append(zipCode)
      .append(location)
      .append(number)
      .append(complement)
      .append(city)
      .append(state)
      .toHashCode();
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
      .append("zipCode", zipCode)
      .append("location", location)
      .append("number", number)
      .append("complement", complement)
      .append("city", city)
      .append("state", state)
      .toString();
  }
}
