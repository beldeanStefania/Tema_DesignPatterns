package com.proiectBetFair.demo.Domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;


@Entity
@NoArgsConstructor
@Table(name = "logger")
public class Logger {

    @Id
    private Long id;
    private static Logger instance = null;

    private Logger(Long id){
        this.id = id;
    }

    public static Logger getInstance(Long id){
        if(instance==null) instance = new Logger(id);
        return instance;
    }

    public Long getId(){
        return id;
    }
}
