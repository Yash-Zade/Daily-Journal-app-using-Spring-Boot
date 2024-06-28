package com.demo.journal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
@Entity
@Data
public class DailyJournal {
    @Id
    private int id;
    private String title;
    private String description;
}
