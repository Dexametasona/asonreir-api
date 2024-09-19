package com.asonreir.management.model.entity;

import com.asonreir.management.model.enums.MaritalStatus;
import com.asonreir.management.model.enums.Sex;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "identification")})
public class Patient {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long  id;

  @Column(length = 50)
  private String name;
  @Column(length = 50)
  private String lastname;
  @Column(length = 50)
  private String identification;
  @Column(length = 50)
  private String phone;
  private LocalDate birthdate;
  @Enumerated(EnumType.STRING)
  private MaritalStatus maritalStatus;
  @Column(length = 50)
  private String job;
  @Enumerated(EnumType.STRING)
  private Sex sex;
  private String disease;
  private String medication;
}
