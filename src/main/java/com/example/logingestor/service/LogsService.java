package com.example.logingestor.service;

import com.example.logingestor.entity.Log;
import com.example.logingestor.models.request.Query;

import java.util.List;

public interface LogsService {
    List<Log> getAllLogs();
    Log saveLog(Log log);
    List<Log> getLogs(Query query);
}
