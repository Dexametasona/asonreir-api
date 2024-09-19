package com.asonreir.management.service;

import com.asonreir.management.model.entity.Supply;
import com.asonreir.management.repository.SupplyRepository;
import com.asonreir.management.service.interfaces.SupplyService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SupplyServiceImp  implements SupplyService {
  private final SupplyRepository supplyRepository;

  @Override
  public Supply create(Supply supply) {
    return this.supplyRepository.save(supply);
  }

  @Override
  public Supply getById(long id) {
    return this.supplyRepository.findById(id)
            .orElseThrow(()->new EntityNotFoundException("Insumo no encontrado, id: "+id));
  }

  @Override
  public Page<Supply> getAll(Pageable pageable) {
    return this.supplyRepository.findAll(pageable);
  }

  @Override
  public Supply update(Supply supply) {
    this.verifyExistById(supply.getId());
    return this.supplyRepository.save(supply);
  }

  @Override
  public void deleteById(long id) {
    this.verifyExistById(id);
    this.supplyRepository.deleteById(id);
  }

  private void verifyExistById(long id){
    boolean isPresent = this.supplyRepository.existsById(id);
    if(!isPresent) throw new EntityNotFoundException("Insumo no encontrado, id:"+id);
  }
}
