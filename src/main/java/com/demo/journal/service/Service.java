package com.demo.journal.service;

import com.demo.journal.entity.DailyJournal;
import org.springframework.beans.factory.annotation.Autowired;
import com.demo.journal.repository.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    private Repository repo;
    public List<DailyJournal> getJournal() {

        return repo.findAll();
    }

    public DailyJournal setJournal(DailyJournal journal) {
        journal.setId(new Random().nextInt(10000));
        journal.setDate(LocalDateTime.now());
        return repo.save(journal);
    }

    public DailyJournal updateJournal(DailyJournal newEntity) {

        return repo.save(newEntity);
    }

    public Optional<DailyJournal> findById(@PathVariable int id){
        return repo.findById(id);
    }
    public void deleteJournal(int id) {
        repo.deleteById(id);
    }
}
