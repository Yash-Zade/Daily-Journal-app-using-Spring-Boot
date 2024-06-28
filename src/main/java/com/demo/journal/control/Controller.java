package com.demo.journal.control;

import com.demo.journal.entity.DailyJournal;
import com.demo.journal.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/DailyJournal")
public class Controller {
    @Autowired
    private DailyJournal journal;
    @Autowired
    private Service service;

    @GetMapping
    public ResponseEntity<?> showJournal(){
        List<DailyJournal> all = service.getJournal();
        if(all!=null && !all.isEmpty())
            return new ResponseEntity<>(all,HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<DailyJournal> findById(@PathVariable int id){
        Optional<DailyJournal> entity = service.findById(id);
        if(entity.isPresent())
            return new ResponseEntity<>(entity.get(), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping
    public ResponseEntity<DailyJournal> saveJournal(@RequestBody DailyJournal journal){
        try{
            service.setJournal(journal);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
    @PutMapping("/id/{id}")
    public ResponseEntity<DailyJournal> updateJournal(@PathVariable int id,@RequestBody DailyJournal journal){
        DailyJournal old = service.findById(id).orElse(null);
        if(old!=null) {
            old.setTitle(journal.getTitle() != null && !journal.getTitle().isEmpty() ? journal.getTitle() : old.getTitle());
            old.setDescription(journal.getDescription() != null && !journal.getDescription().isEmpty() ? journal.getDescription() : old.getDescription());
            service.updateJournal(old);
            return new ResponseEntity<>(old, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<DailyJournal> deleteJournal(@PathVariable int id){

        service.deleteJournal(id);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
