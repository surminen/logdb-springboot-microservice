package com.surminen.springboot.microservice.logdb.springbootmicroservicelogdb;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LogDataRepository extends JpaRepository<LogData, Long>
{
    LogData[] findByDate(LocalDate date);
    
    /**
     * Finds a person by using the last name as a search criteria.
     * @param lastName
     * @return  A list of persons whose last name is an exact match with the given last name.
     *          If no persons is found, this method returns an empty list.
     */
    @Query(value = "SELECT * FROM log_data WHERE log_content LIKE CONCAT('%',?1,'%')", nativeQuery = true)
    List<LogData> findByContent(String content);
    
    @Override
    LogData save(LogData data);
    
}