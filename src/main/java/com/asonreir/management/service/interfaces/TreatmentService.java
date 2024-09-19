package com.asonreir.management.service.interfaces;

import com.asonreir.management.model.entity.Treatment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TreatmentService {
  Treatment create(Treatment treatment);
  Treatment getById(long id);
  Page<Treatment> getAll(Pageable pageable);
  Treatment update(Treatment treatment);
  void deleteById(long id);
}
