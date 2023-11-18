package com.example.logingestor.service;

import com.example.logingestor.entity.Log;
import com.example.logingestor.models.Metadata;
import com.example.logingestor.models.request.Query;
import com.example.logingestor.repo.LogsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LogsServiceImpl implements LogsService {
    private final LogsRepo logsRepo;

    @Autowired
    public LogsServiceImpl(LogsRepo logsRepo) {
        this.logsRepo = logsRepo;
    }

    @Override
    public Log saveLog(Log log) {
        return logsRepo.save(log);
    }

    @Override
    public List<Log> getLogs(Query query) {
        if (!(query.equals(new Query(null, null, null, null, null, null, null, new Metadata(null)))))
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
        else {
            return logsRepo.findAll(); // Return all logs if no filters are provided
        }
    }
}
