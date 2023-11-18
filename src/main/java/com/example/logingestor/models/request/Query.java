package com.example.logingestor.models.request;

import com.example.logingestor.models.Metadata;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Query {
    private String level;
    private String message;
    private String resourceId;
    private LocalDateTime timestamp;
    private String traceId;
    private String spanId;
    private String commit;
    private Metadata metadata;
}
