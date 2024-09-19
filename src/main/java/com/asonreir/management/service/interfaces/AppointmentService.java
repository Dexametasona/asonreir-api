package com.asonreir.management.service.interfaces;

import com.asonreir.management.model.entity.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AppointmentService {
  Appointment create(Appointment appointment);
  Appointment getById(long id);
  Page<Appointment> getAll(Pageable pageable);
  Appointment update(Appointment appointment);
  void deleteById(long id);
}
