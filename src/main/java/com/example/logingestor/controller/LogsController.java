package com.example.logingestor.controller;

import com.example.logingestor.entity.Log;
import com.example.logingestor.models.request.Query;
import com.example.logingestor.models.response.ApiResponse;
import com.example.logingestor.service.LogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<ApiResponse> getLogs(@RequestBody Query query){
        ApiResponse apiResponse=new ApiResponse();
        apiResponse.setData(logsService.getLogs(query));
        return ResponseEntity.ok(apiResponse);
    }
}
