package com.asonreir.management.model.entity;

import com.asonreir.management.model.enums.Type;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountLog {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Type type;
  private LocalDate date;

  @ManyToOne
  @JoinColumn(name = "supply_id")
  private Supply supply;
  
  @ManyToOne
  @JoinColumn(name = "treatment_id")
  private Treatment treatment;
}
