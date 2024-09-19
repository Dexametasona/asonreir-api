package com.asonreir.management.model.entity;

import com.asonreir.management.model.enums.AppointmentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private LocalDate date;
  @Enumerated(EnumType.STRING)
  @Column(length = 20)
  private AppointmentStatus status;
  @Column(length = 100)
  private String name;
  @Column(length = 20)
  private String phone;

  @ManyToOne
  @JoinColumn(name = "patient_id")
  private Patient patient;
}
