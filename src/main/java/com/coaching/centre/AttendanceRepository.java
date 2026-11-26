package com.coaching.centre;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<Attendance,Integer>{
    boolean existsByEnrolmentIdAndDate(int enrolmentId, LocalDate date);
}
