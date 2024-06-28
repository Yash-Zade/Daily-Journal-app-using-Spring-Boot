package com.demo.journal.repository;

import com.demo.journal.entity.DailyJournal;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<DailyJournal,Integer> {

}
