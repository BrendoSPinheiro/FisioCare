package br.com.brendosp.fisiocare.modules.patientrecord.entities;

import br.com.brendosp.fisiocare.modules.BaseEntity;
import br.com.brendosp.fisiocare.modules.patientrecord.entities.enums.Gender;
import br.com.brendosp.fisiocare.modules.patientrecord.entities.enums.PatientStatus;
import br.com.brendosp.fisiocare.modules.patientrecord.utils.GenderEnumConverter;
import br.com.brendosp.fisiocare.modules.patientrecord.utils.PatientStatusEnumConverter;
import br.com.brendosp.fisiocare.modules.user.entities.User;
import jakarta.persistence.*;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "tb_patient_records")
public class PatientRecord extends BaseEntity {

  @Column(length = 100, nullable = false)
  private String name;

  @Column(nullable = false, unique = true)
  private String email;

  @Column
  private String photo;

  @Column(nullable = false)
  private LocalDate birthdate;

  @Column(nullable = false)
  @Convert(converter = GenderEnumConverter.class)
  private Gender gender;

  @Embedded
  private Address address;

  @Column(length = 45, nullable = false)
  private String occupation;

  @Column(name = "clinical_diagnosis", columnDefinition = "TEXT")
  private String clinicalDiagnosis;

  @Column(columnDefinition = "TEXT", nullable = false)
  private String complaint;

  @Column(name = "hmp_hma", columnDefinition = "TEXT")
  private String hmpHma;

  @Column(columnDefinition = "TEXT")
  private String medications;

  @Column(name = "complementary_exams", columnDefinition = "TEXT")
  private String complementaryExams;

  @Column(name = "physical_exam", columnDefinition = "TEXT")
  private String physicalExam;

  @Column(name = "clinical_conduct", columnDefinition = "TEXT")
  private String clinicalConduct;

  @Column(columnDefinition = "TEXT")
  private String diagnosis;

  @Column(nullable = false)
  @Convert(converter = PatientStatusEnumConverter.class)
  private PatientStatus status;

  @Column(nullable = false, unique = true)
  private UUID uuid;

  @ManyToOne
  @JoinColumn(name = "therapist_id", referencedColumnName = "id")
  private User therapist;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhoto() {
    return photo;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }

  public LocalDate getBirthdate() {
    return birthdate;
  }

  public void setBirthdate(LocalDate birthdate) {
    this.birthdate = birthdate;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public String getOccupation() {
    return occupation;
  }

  public void setOccupation(String occupation) {
    this.occupation = occupation;
  }

  public String getClinicalDiagnosis() {
    return clinicalDiagnosis;
  }

  public void setClinicalDiagnosis(String clinicalDiagnosis) {
    this.clinicalDiagnosis = clinicalDiagnosis;
  }

  public String getComplaint() {
    return complaint;
  }

  public void setComplaint(String complaint) {
    this.complaint = complaint;
  }

  public String getHmpHma() {
    return hmpHma;
  }

  public void setHmpHma(String hmpHma) {
    this.hmpHma = hmpHma;
  }

  public String getMedications() {
    return medications;
  }

  public void setMedications(String medications) {
    this.medications = medications;
  }

  public String getComplementaryExams() {
    return complementaryExams;
  }

  public void setComplementaryExams(String complementaryExams) {
    this.complementaryExams = complementaryExams;
  }

  public String getPhysicalExam() {
    return physicalExam;
  }

  public void setPhysicalExam(String physicalExam) {
    this.physicalExam = physicalExam;
  }

  public String getClinicalConduct() {
    return clinicalConduct;
  }

  public void setClinicalConduct(String clinicalConduct) {
    this.clinicalConduct = clinicalConduct;
  }

  public String getDiagnosis() {
    return diagnosis;
  }

  public void setDiagnosis(String diagnosis) {
    this.diagnosis = diagnosis;
  }

  public PatientStatus getStatus() {
    return status;
  }

  public void setStatus(PatientStatus status) {
    this.status = status;
  }

  public UUID getUuid() {
    return uuid;
  }

  public void setUuid(UUID uuid) {
    this.uuid = uuid;
  }

  public User getTherapist() {
    return therapist;
  }

  public void setTherapist(User therapist) {
    this.therapist = therapist;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;

    if (!(o instanceof PatientRecord that)) return false;

    return new EqualsBuilder().appendSuper(super.equals(o))
      .append(name, that.name).append(email, that.email)
      .append(photo, that.photo).append(birthdate, that.birthdate)
      .append(gender, that.gender).append(address, that.address)
      .append(occupation, that.occupation).append(clinicalDiagnosis, that.clinicalDiagnosis)
      .append(complaint, that.complaint).append(hmpHma, that.hmpHma)
      .append(medications, that.medications).append(complementaryExams, that.complementaryExams)
      .append(physicalExam, that.physicalExam).append(clinicalConduct, that.clinicalConduct)
      .append(diagnosis, that.diagnosis).append(status, that.status)
      .append(uuid, that.uuid).append(therapist, that.therapist)
      .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37)
      .appendSuper(super.hashCode())
      .append(name).append(email)
      .append(photo).append(birthdate)
      .append(gender).append(address)
      .append(occupation).append(clinicalDiagnosis)
      .append(complaint).append(hmpHma)
      .append(medications).append(complementaryExams)
      .append(physicalExam).append(clinicalConduct)
      .append(diagnosis).append(status)
      .append(uuid).append(therapist)
      .toHashCode();
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this)
      .append("name", name)
      .append("email", email)
      .append("photo", photo)
      .append("birthdate", birthdate)
      .append("gender", gender)
      .append("address", address)
      .append("occupation", occupation)
      .append("clinicalDiagnosis", clinicalDiagnosis)
      .append("complaint", complaint)
      .append("hmpHma", hmpHma)
      .append("medications", medications)
      .append("complementaryExams", complementaryExams)
      .append("physicalExam", physicalExam)
      .append("clinicalConduct", clinicalConduct)
      .append("diagnosis", diagnosis)
      .append("status", status)
      .append("uuid", uuid)
      .append("therapist", therapist)
      .toString();
  }
}
