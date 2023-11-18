package com.example.logingestor.models.request;

import com.example.logingestor.models.Metadata;
import lombok.Data;

import java.util.Date;
import java.util.Map;

@Data
public class Query {
    private String level;
    private String message;
    private String resourceId;
    private Date timestamp=new Date();
    private String traceId;
    private String spanId;
    private String commit;
    private Metadata metadata;
}
