package com.demo.journal.service;

import com.demo.journal.entity.DailyJournal;
import org.springframework.beans.factory.annotation.Autowired;
import com.demo.journal.repository.Repository;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    private Repository repo;
    public List<DailyJournal> getJournal() {

        return repo.findAll();
    }

    public DailyJournal setJournal(DailyJournal journal) {

        return repo.save(journal);
    }

    public DailyJournal updateJournal(DailyJournal journal) {

        return repo.save(journal);
    }

    public void deleteJournal(int id) {
        repo.deleteById(id);
    }
}
