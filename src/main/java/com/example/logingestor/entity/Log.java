package com.example.logingestor.entity;

import com.example.logingestor.models.Metadata;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Document(collection = "logs")
@NoArgsConstructor
public class Log {
    private String level;
    private String message;
    private String resourceId;
    private LocalDateTime timestamp;
    private String traceId;
    private String spanId;
    private String commit;
    private Metadata metadata;
}
