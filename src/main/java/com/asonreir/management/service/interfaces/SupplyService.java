package com.asonreir.management.service.interfaces;

import com.asonreir.management.model.entity.Supply;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SupplyService {
  Supply create(Supply supply);
  Supply getById(long id);
  Page<Supply> getAll(Pageable pageable);
  Supply update(Supply supply);
  void deleteById(long id);
}
