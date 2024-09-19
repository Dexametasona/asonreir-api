package com.asonreir.management.service.interfaces;

import com.asonreir.management.model.entity.AccountLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AccountLogService {
  AccountLog create(AccountLog accountLog);
  AccountLog getById(long id);
  Page<AccountLog> getAll(Pageable pageable);
  AccountLog update(AccountLog accountLog);
  void deleteById(long id);
}
