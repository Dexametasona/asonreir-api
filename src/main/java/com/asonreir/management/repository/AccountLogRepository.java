package com.asonreir.management.repository;

import com.asonreir.management.model.entity.AccountLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountLogRepository extends JpaRepository<AccountLog, Long> {
}
