package com.asonreir.management.service;

import com.asonreir.management.model.entity.Treatment;
import com.asonreir.management.repository.TreatmentRepository;
import com.asonreir.management.service.interfaces.TreatmentService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TreatmentServiceImp implements TreatmentService {
  private final TreatmentRepository treatmentRepository;
  @Override
  public Treatment create(Treatment treatment) {
    return this.treatmentRepository.save(treatment);
  }

  @Override
  public Treatment getById(long id) {
    return this.treatmentRepository.findById(id)
            .orElseThrow(()->new EntityNotFoundException("Tratamiento no encontrado, id: "+id));
  }

  @Override
  public Page<Treatment> getAll(Pageable pageable) {
    return this.treatmentRepository.findAll(pageable);
  }

  @Override
  public Treatment update(Treatment treatment) {
    this.verifyExistById(treatment.getId());
    return this.treatmentRepository.save(treatment);
  }

  @Override
  public void deleteById(long id) {
    this.verifyExistById(id);
    this.treatmentRepository.deleteById(id);
  }

  private void verifyExistById(long id){
    boolean isPresent = this.treatmentRepository.existsById(id);
    if(!isPresent) throw new EntityNotFoundException("Tratamiento no encontrado, id:"+id);
  }
}
