package com.cts.adoptionanalyzer.bookmark.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Document(collection = "bookmark")
public record Bookmark(
        @Id
        String id,
        String userId,
        String jobId,
        String notes,

        LocalDateTime createdDate

){}
