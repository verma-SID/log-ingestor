package com.example.logingestor.models.request;

import com.example.logingestor.models.Metadata;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;

@Data
@NoArgsConstructor
public class Query {
    private String level;
    private String message;
    private String resourceId;
    private LocalDateTime timestamp;
    private String traceId;
    private String spanId;
    private String commit;
    private Metadata metadata;

    @Builder
    public Query(String level, String message, String resourceId, LocalDateTime timestamp, String traceId, String spanId, String commit, Metadata metadata) {
        this.level = level;
        this.message = message;
        this.resourceId = resourceId;
        this.timestamp = timestamp;
        this.traceId = traceId;
        this.spanId = spanId;
        this.commit = commit;
        this.metadata = metadata != null ? metadata : new Metadata();
    }

}
