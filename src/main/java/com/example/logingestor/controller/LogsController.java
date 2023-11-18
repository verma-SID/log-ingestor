package com.example.logingestor.controller;

import com.example.logingestor.entity.Log;
import com.example.logingestor.models.Metadata;
import com.example.logingestor.models.request.Query;
import com.example.logingestor.models.response.ApiResponse;
import com.example.logingestor.service.LogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/logsIngestor")
public class LogsController {
    private final LogsService logsService;
    @Autowired
    public LogsController(LogsService logsService) {
        this.logsService = logsService;
    }
    @PostMapping("/saveLog")
    public ResponseEntity<ApiResponse> saveLog(@RequestBody Log log){
        ApiResponse apiResponse=new ApiResponse();
        apiResponse.setData(logsService.saveLog(log));
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/getLogs")
    public ResponseEntity<ApiResponse> getLogs(@RequestParam(required = false) String level,
                                               @RequestParam(required = false) String message,
                                               @RequestParam(required = false) String resourceId,
                                               @RequestParam(required = false) String timestamp,
                                               @RequestParam(required = false) String traceId,
                                               @RequestParam(required = false) String spanId,
                                               @RequestParam(required = false) String commit,
                                               @RequestParam(required = false) String parentResourceId) {
        Query query = new Query();
        query.setLevel(level);
        query.setMessage(message);
        query.setResourceId(resourceId);

        // Convert timestamp string to LocalDateTime (Assuming format is ISO_LOCAL_DATE_TIME)
        LocalDateTime parsedTimestamp = null;
        if (timestamp != null && !timestamp.isEmpty()) {
            parsedTimestamp = LocalDateTime.parse(timestamp);
        }
        query.setTimestamp(parsedTimestamp);

        query.setTraceId(traceId);
        query.setSpanId(spanId);
        query.setCommit(commit);

        // Initialize metadata if it's null
        if (query.getMetadata() == null) {
            query.setMetadata(new Metadata());
        }

        // Set parentResourceId in metadata
        query.getMetadata().setParentResourceId(parentResourceId);

        List<Log> filteredLogs = logsService.getLogs(query);

        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setData(filteredLogs);
        return ResponseEntity.ok(apiResponse);
    }
}
