package com.example.logingestor.service;

import com.example.logingestor.entity.Log;
import com.example.logingestor.models.request.Query;
import com.example.logingestor.repo.LogsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class LogsServiceImpl implements LogsService{
    private final LogsRepo logsRepo;
    @Autowired
    public LogsServiceImpl(LogsRepo logsRepo) {
        this.logsRepo = logsRepo;
    }

    public List<Log> getAllLogs() {
        return logsRepo.findAll(); // Fetch all logs from the database
    }

    @Override
    public Log saveLog(Log log) {
        return logsRepo.save(log);
    }

    @Override
    public List<Log> getLogs(Query query) {
        if (query != null) {
            return logsRepo.findByFilters(
                    query.getLevel(),
                    query.getMessage(),
                    query.getResourceId(),
                    query.getTimestamp(),
                    query.getTraceId(),
                    query.getSpanId(),
                    query.getCommit(),
                    query.getMetadata().getParentResourceId()
            );
        } else {
            return getAllLogs(); // Return all logs if no filters are provided
        }
    }
}
