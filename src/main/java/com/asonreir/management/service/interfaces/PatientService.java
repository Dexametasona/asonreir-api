package com.asonreir.management.service.interfaces;

import com.asonreir.management.model.entity.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface PatientService {
  Patient create(Patient patient);
  Patient getById(long id);
  Page<Patient> getAll(Pageable pageable);
  Patient update(Patient patient);
  void deleteById(long id);
}
