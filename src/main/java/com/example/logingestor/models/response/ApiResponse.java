package com.example.logingestor.models.response;

import lombok.Data;

@Data
public class ApiResponse {
    private boolean success=true;
    private Object data;
}
