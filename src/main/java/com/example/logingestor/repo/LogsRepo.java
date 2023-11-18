package com.example.logingestor.repo;

import com.example.logingestor.entity.Log;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface LogsRepo extends MongoRepository<Log,String> {
    List<Log> findByLevel(String value);
    @Query("{'level': ?0, 'message': ?1, 'resourceId': ?2, 'timestamp': ?3, 'traceId': ?4, 'spanId': ?5, 'commit': ?6, 'metadata.parentResourceId': ?7}")
    List<Log> findByFilters(
            String level,
            String message,
            String resourceId,
            LocalDateTime timestamp,
            String traceId,
            String spanId,
            String commit,
            String parentResourceId
    );
}
