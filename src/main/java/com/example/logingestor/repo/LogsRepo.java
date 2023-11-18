package com.example.logingestor.repo;

import com.example.logingestor.entity.Log;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LogsRepo extends MongoRepository<Log,String> {
    List<Log> findByLevel(String value);
}
