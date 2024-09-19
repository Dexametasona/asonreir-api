package com.asonreir.management.service;

import com.asonreir.management.model.entity.Appointment;
import com.asonreir.management.repository.AppointmentRepository;
import com.asonreir.management.service.interfaces.AppointmentService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImp implements AppointmentService {
  private final AppointmentRepository appointmentRepository;
  @Override
  public Appointment create(Appointment appointment) {
    return this.appointmentRepository.save(appointment);
  }

  @Override
  public Appointment getById(long id) {
    return this.appointmentRepository.findById(id)
            .orElseThrow(()->new EntityNotFoundException(""));
  }

  @Override
  public Page<Appointment> getAll(Pageable pageable) {
    return this.appointmentRepository.findAll(pageable);
  }

  @Override
  public Appointment update(Appointment appointment) {
    this.verifyExistById(appointment.getId());
    return this.appointmentRepository.save(appointment);
  }

  @Override
  public void deleteById(long id) {
    this.verifyExistById(id);
    this.appointmentRepository.deleteById(id);
  }

  private void verifyExistById(long id){
    boolean isPresent = this.appointmentRepository.existsById(id);
    if(!isPresent) throw new EntityNotFoundException("Cita no encontrada, id:"+id);
  }
}
