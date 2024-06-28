package com.demo.journal.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;
@Component
@Entity
@Data
public class DailyJournal {
    @Id
    private int id;
    @Column(nullable = false)
    private String title;
    private String description;
    private LocalDateTime date;

}
