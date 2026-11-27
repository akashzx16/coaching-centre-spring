package com.coaching.centre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrolmentRepository extends JpaRepository<Enrolment,Integer> {
    boolean existsByStudentIdAndBatchIdAndLeavingDateIsNull(int studentId, int batchId);
    boolean existsByStudentIdAndBatchIdAndLeavingDateIsNullAndIdNot(int studentId, int batchId, int id);

}
