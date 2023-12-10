package com.proiectBetFair.demo.Controller;


import com.proiectBetFair.demo.Domain.Logger;
import com.proiectBetFair.demo.Repository.LoggerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class LoggerController {

    @Autowired
    LoggerRepository loggerRepository;

    @GetMapping("/logger/getAll")
    public List<Logger> getAll(){ return loggerRepository.findAll();}

    @PostMapping("/logger/create")
    public Logger createLogger(@RequestBody Logger logger){
        Logger.getInstance(logger.getId());
        return loggerRepository.save(Logger.getInstance(logger.getId()));
    }

}
