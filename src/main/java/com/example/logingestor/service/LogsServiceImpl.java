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

    @Override
    public Log saveLog(Log log) {
        return logsRepo.save(log);
    }

    @Override
    public List<Log> getLogs(Query query) {
        if(query.getLevel()!=null){
            return logsRepo.findByLevel(query.getLevel());
        }
        return null;
    }
}
