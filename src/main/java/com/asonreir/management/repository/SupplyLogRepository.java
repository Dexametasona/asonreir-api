package com.asonreir.management.repository;

import com.asonreir.management.model.entity.SupplyLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplyLogRepository extends JpaRepository<SupplyLog, Long> {
}
