package com.demo.journal.control;

import com.demo.journal.entity.DailyJournal;
import com.demo.journal.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/DailyJournal")
public class Controller {
    @Autowired
    private DailyJournal journal;
    @Autowired
    private Service service;

    @GetMapping
    public List<DailyJournal> showJournal(){
        return service.getJournal();
    }
    @PostMapping
    public DailyJournal saveJournal(@RequestBody DailyJournal journal){
        return service.setJournal(journal);
    }
    @PutMapping
    public DailyJournal updateJournal(@RequestBody DailyJournal journal){
        return service.updateJournal(journal);
    }
    @DeleteMapping("/{id}")
    public void deleteJournal(@PathVariable int id){
         service.deleteJournal(id);
    }

}
