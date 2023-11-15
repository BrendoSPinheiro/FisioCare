package br.com.brendosp.fisiocare.modules.patientrecord.entities;

import br.com.brendosp.fisiocare.modules.BaseEntity;
import br.com.brendosp.fisiocare.modules.patientrecord.entities.enums.Gender;
import br.com.brendosp.fisiocare.modules.patientrecord.entities.enums.PatientStatus;
import br.com.brendosp.fisiocare.modules.patientrecord.utils.GenderEnumConverter;
import br.com.brendosp.fisiocare.modules.patientrecord.utils.PatientStatusEnumConverter;
import br.com.brendosp.fisiocare.modules.user.entities.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@Table(name = "tb_patient_records")
@EqualsAndHashCode(callSuper = true)
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
}
