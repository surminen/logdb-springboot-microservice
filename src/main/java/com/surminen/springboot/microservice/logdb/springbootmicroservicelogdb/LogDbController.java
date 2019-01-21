package com.surminen.springboot.microservice.logdb.springbootmicroservicelogdb;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 */
@RestController
public class LogDbController
{
    @Autowired
    private Environment environment;

    @Autowired
    private LogDataRepository repository;

    @GetMapping("/log-data/date/{date}")
    public LogData[] retrieveLogDataBasedOnDate(@PathVariable String date) throws ParseException
    {
        LocalDate d = decodeDate(date);
        System.out.println("To Date: " + d.toString());

        LogData[] logData = repository.findByDate(d);

        return logData;
    }

    @GetMapping("/log-data/show")
    public List<LogData> retrieveAllLogData()
    {
        List<LogData> logData = repository.findAll();
        return logData;
    }
    
    @PutMapping("/log-data/add")
    public void addLogData(@RequestBody LogData data) throws ParseException
    {
        System.out.println("New data: " + data.toString());
        repository.save(data);
    }
    
    @GetMapping("/log-data/contains/{content}")
    public List<LogData> retrieveLogDataBasedOnContent(@PathVariable String content) throws ParseException
    {
        System.out.println("Content: " + content);

        List<LogData> x = repository.findByContent(content);
        
        // TODO
        // LogData logData = repository.findByContent(content);
        // logData.setPort(Integer.parseInt(environment.getProperty("local.server.port")));

        // return logData;
        return x;
    }

    /**
     * TODO
     * 
     * @param date
     * @return
     * @throws ParseException
     */
    private LocalDate decodeDate(String date) throws ParseException
    {
        // return from.replace("_", "/");
        System.out.println("Converting: " + date);
        Date x = new SimpleDateFormat("dd/MM/yyyy").parse(date.replace("_", "/"));
        LocalDate y = LocalDate.parse(date.replace("_", "/"), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        
        return y;

    }
}