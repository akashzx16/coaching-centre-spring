package com.coaching.centre;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import jakarta.validation.Valid;

@RestController 
@RequestMapping ("/batches")
public class BatchController {
    private final BatchRepository repository;
    public BatchController(BatchRepository repository){
        this.repository=repository;
    }   

    @PostMapping 
    public ResponseEntity <Object> createBatch (@Valid @RequestBody Batch batch){
        if (repository.existsById(batch.getId())){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        Batch savedBatch = repository.save(batch);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBatch);
    }

    @GetMapping 
    public List<Batch> getAllBatch(){
        return repository.findAll();
    }

    @GetMapping ("/{id}")
            public ResponseEntity <Batch> getBatch(@PathVariable int id){
                return repository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
            }
    @PutMapping ("/{id}")
            public ResponseEntity<Batch> updateBatch (@PathVariable int id, @Valid @RequestBody Batch updatedbBatch){
                if(repository.existsById(id)){
                    Batch batch = repository.findById(id).get(); 
                    batch.setName(updatedbBatch.getName());
                    batch.setSubject(updatedbBatch.getSubject());
                    batch.setSchedule(updatedbBatch.getSchedule());
                    Batch saved = repository.save(batch);
                    return ResponseEntity.ok(saved);
                }
                else{
                    return ResponseEntity.notFound().build();
                }
                   
            }
            @DeleteMapping("/{id}")
            public ResponseEntity<Void> deleteBatch(@PathVariable int id){
                if(repository.existsById(id)){
                    repository.deleteById(id);
                    return ResponseEntity.noContent().build();
                }
                else{
                    return ResponseEntity.notFound().build();
                }
            } 
            
    }






