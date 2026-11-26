package com.coaching.centre;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController 
@RequestMapping ("/attendance")
public class AttendanceController {
    private final AttendanceRepository attendanceRepository;
    private final EnrolmentRepository enrolmentRepository;
    public AttendanceController (AttendanceRepository attendanceRepository, EnrolmentRepository enrolmentRepository){
        this.attendanceRepository=attendanceRepository;
        this.enrolmentRepository=enrolmentRepository;
    }

    @PostMapping 
    public ResponseEntity <Attendance> createAttendance(@Valid @RequestBody Attendance attendance){
            if (attendanceRepository.existsById(attendance.getId())){
                return ResponseEntity.status(HttpStatus.CONFLICT).build();
            }
            if (!enrolmentRepository.existsById(attendance.getEnrolmentId())){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            if(attendanceRepository.existsByEnrolmentIdAndDate(attendance.getEnrolmentId(),attendance.getDate())){
                    return ResponseEntity.status(HttpStatus.CONFLICT).build();
            }
            Attendance savAttendance = attendanceRepository.save(attendance);
            return ResponseEntity.status(HttpStatus.CREATED).body(savAttendance);
    }
    @GetMapping 
    public List<Attendance> getAllAttendance(){
        return attendanceRepository.findAll();
    }
    @GetMapping ("/{id}")
    public ResponseEntity<Attendance> getAttendanceById(@PathVariable int id){
            Optional<Attendance> attendance = attendanceRepository.findById(id);
            if(attendance.isPresent()){
                return ResponseEntity.ok(attendance.get());
            }
            return  ResponseEntity.notFound().build();  
    }
    
}
