package com.example.logingestor.entity;

import com.example.logingestor.models.Metadata;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document
public class Log{
    private String level;
    private String message;
    private String resourceId;
    private Date timestamp=new Date();
    private String traceId;
    private String spanId;
    private String commit;
    private Metadata metadata;
}
