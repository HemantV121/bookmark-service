package com.cts.adoptionanalyzer.bookmark.dto;


import java.time.LocalDateTime;

public record BookmarkResponseDTO(
        String id,
        String userId,
        String jobId,
        String notes,
        LocalDateTime createdTime
){}
