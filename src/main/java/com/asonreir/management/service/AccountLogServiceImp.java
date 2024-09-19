package com.asonreir.management.service;

import com.asonreir.management.model.entity.AccountLog;
import com.asonreir.management.repository.AccountLogRepository;
import com.asonreir.management.service.interfaces.AccountLogService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountLogServiceImp implements AccountLogService {
  private final AccountLogRepository accountLogRepository;
  @Override
  public AccountLog create(AccountLog accountLog) {
    return this.accountLogRepository.save(accountLog);
  }

  @Override
  public AccountLog getById(long id) {
    return this.accountLogRepository.findById(id)
            .orElseThrow(()->new EntityNotFoundException("Movimiento no encontrado, id: "+id));
  }

  @Override
  public Page<AccountLog> getAll(Pageable pageable) {
    return this.accountLogRepository.findAll(pageable);
  }

  @Override
  public AccountLog update(AccountLog accountLog) {
    this.verifyExistById(accountLog.getId());
    return this.accountLogRepository.save(accountLog);
  }

  @Override
  public void deleteById(long id) {
    this.verifyExistById(id);
    this.accountLogRepository.deleteById(id);
  }

  private void verifyExistById(long id){
    boolean isPresent = this.accountLogRepository.existsById(id);
    if(!isPresent) throw new EntityNotFoundException("Movimiento no encontrado, id:"+id);
  }
}
