package com.asonreir.management.service;

import com.asonreir.management.model.entity.Patient;
import com.asonreir.management.repository.PatientRepository;
import com.asonreir.management.service.interfaces.PatientService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientServiceImp implements PatientService {
  private final PatientRepository patientRepo;

  @Override
  public Patient create(Patient patient) {
    return this.patientRepo.save(patient);
  }

  @Override
  public Patient getById(long id) {
    return this.patientRepo.findById(id)
            .orElseThrow(()->new EntityNotFoundException("Paciente no encontrado, id: "+id));
  }

  @Override
  public Page<Patient> getAll(Pageable pageable) {
    return this.patientRepo.findAll(pageable);
  }

  @Override
  public Patient update(Patient patient) {
    this.verifyExistById(patient.getId());
    return this.patientRepo.save(patient);
  }

  @Override
  public void deleteById(long id) {
    this.verifyExistById(id);
    this.patientRepo.deleteById(id);
  }

  private void verifyExistById(long id){
    boolean isPresent = this.patientRepo.existsById(id);
    if(!isPresent) throw new EntityNotFoundException("Paciente no encontrado, id:"+id);
  }
}
