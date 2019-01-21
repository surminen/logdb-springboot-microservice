package com.surminen.springboot.microservice.logdb.springbootmicroservicelogdb;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Contains the information about a log entry
 */
@Entity
public class LogData
{

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "date_created")
    private LocalDate date;

    @Column(name = "log_content")
    private String log;

    /**
     * Default constructor.
     */
    public LogData()
    {

    }

    /**
     * Constructor. Constructs this object with all information set.
     * 
     * @param _id
     * @param _date
     * @param _log
     */
    public LogData(Long _id, LocalDate _date, String _log)
    {
        super();
        id = _id;
        date = _date;
        log = _log;
    }

    /**
     * @return the id
     */
    public Long getId()
    {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(Long id)
    {
        this.id = id;
    }

    /**
     * @return the date
     */
    public LocalDate getDate()
    {
        return date;
    }

    /**
     * @param date
     *            the date to set
     */
    public void setDate(LocalDate date)
    {
        this.date = date;
    }

    /**
     * @return the log
     */
    public String getLog()
    {
        return log;
    }

    /**
     * @param log
     *            the log to set
     */
    public void setLog(String log)
    {
        this.log = log;
    }

    @Override
    public String toString()
    {
        return "ID: " + id + ", date: " + date + ", log: " + log;
    }
}