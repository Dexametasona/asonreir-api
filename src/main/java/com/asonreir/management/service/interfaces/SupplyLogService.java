package com.asonreir.management.service.interfaces;

import com.asonreir.management.model.entity.SupplyLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SupplyLogService {
  SupplyLog create(SupplyLog supplyLog);
  SupplyLog getById(long id);
  Page<SupplyLog> getAll(Pageable pageable);
  SupplyLog update(SupplyLog supplyLog);
  void deleteById(long id);
}
