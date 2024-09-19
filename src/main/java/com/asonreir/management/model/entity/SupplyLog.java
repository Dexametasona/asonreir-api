package com.asonreir.management.model.entity;

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
public class SupplyLog {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private LocalDate date;
  @Column(columnDefinition = "SMALLINT")
  private int quantity;

  @ManyToOne
  @JoinColumn(name = "supply_id")
  private Supply supply;
}
