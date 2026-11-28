package com.coaching.centre;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FeeRateHistoryRepository extends JpaRepository<FeeRateHistory,Integer> {
    boolean existsByBatchIdAndEffectiveFrom(int batchId,LocalDate effectiveFrom);
    Optional<FeeRateHistory> findFirstByBatchIdAndEffectiveFromLessThanEqualOrderByEffectiveFromDesc(
    int batchId, LocalDate cycleStart
);
}
