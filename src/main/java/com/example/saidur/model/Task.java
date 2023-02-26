package com.example.saidur.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity //mark class as entity
@Table //defining class name as Table name
public class Task {

    @Column //defining id as primary key
    @Id
    private Long id;


    @Column
    private String description;

    @Column
    private LocalDate duedate;

    @Column
    private Boolean completed;


    @ManyToOne
    private User user;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDuedate() {
        return duedate;
    }

    public void setDuedate(LocalDate duedate) {
        this.duedate = duedate;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
