package com.asonreir.management.service;

import com.asonreir.management.model.entity.SupplyLog;
import com.asonreir.management.repository.SupplyLogRepository;
import com.asonreir.management.service.interfaces.SupplyLogService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SupplyLogServiceImp implements SupplyLogService {
 private final SupplyLogRepository supplyLogRepository;

  @Override
  public SupplyLog create(SupplyLog supplyLog) {
    return this.supplyLogRepository.save(supplyLog);
  }

  @Override
  public SupplyLog getById(long id) {
    return this.supplyLogRepository.findById(id)
            .orElseThrow(()->new EntityNotFoundException("Registro de insumo no encontrado, id: "+id));
  }

  @Override
  public Page<SupplyLog> getAll(Pageable pageable) {
    return this.supplyLogRepository.findAll(pageable);
  }

  @Override
  public SupplyLog update(SupplyLog supplyLog) {
    this.verifyExistById(supplyLog.getId());
    return this.supplyLogRepository.save(supplyLog);
  }

  @Override
  public void deleteById(long id) {
    this.verifyExistById(id);
    this.supplyLogRepository.deleteById(id);
  }

  private void verifyExistById(long id){
    boolean isPresent = this.supplyLogRepository.existsById(id);
    if(!isPresent) throw new EntityNotFoundException("Registro de insumo no encontrado, id:"+id);
  }
}
